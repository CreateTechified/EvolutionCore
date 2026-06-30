package io.github.createtechified.evolutioncore.common.machine.steam;

import brachy.modularui.drawable.GuiTextures;
import brachy.modularui.drawable.Icon;
import brachy.modularui.factory.PosGuiData;
import brachy.modularui.screen.UISettings;
import brachy.modularui.utils.Alignment;
import brachy.modularui.value.sync.PanelSyncManager;
import brachy.modularui.widget.ParentWidget;
import brachy.modularui.widgets.ListWidget;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.blockentity.BlockEntityCreationInfo;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.steam.SteamEnergyRecipeHandler;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableFluidTank;
import com.gregtechceu.gtceu.api.machine.trait.RecipeHandlerList;
import com.gregtechceu.gtceu.api.multiblock.error.PatternStringError;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.api.sync_system.annotations.SyncToClient;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import com.gregtechceu.gtceu.common.mui.GTMultiblockTextUtil;
import com.gregtechceu.gtceu.config.ConfigHolder;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HPSteamParallelMultiblockMachine extends SteamParallelMultiblockMachine {
    @Getter
    @Setter
    private int maxParallels;

    @Nullable
    @SyncToClient
    private SteamEnergyRecipeHandler steamEnergy = null;

    public HPSteamParallelMultiblockMachine(BlockEntityCreationInfo info) {
        super(info, ConfigHolder.INSTANCE.machines.steamMultiParallelAmount * 4);
    }

    public static ModifierFunction recipeModifier(MetaMachine machine, GTRecipe recipe) {
        if (!(machine instanceof HPSteamParallelMultiblockMachine steamMachine)) {
            return RecipeModifier.nullWrongType(HPSteamParallelMultiblockMachine.class, machine);
        }
        if (RecipeHelper.getRecipeEUtTier(recipe) > GTValues.LV) return ModifierFunction.NULL;

        long eut = recipe.getInputEUt().getTotalEU();
        int parallelAmount = ParallelLogic.getParallelAmount(machine, recipe, steamMachine.maxParallels);
        double eutMultiplier = (eut * 0.8888 * parallelAmount <= 32) ? (0.8888 * parallelAmount) : (32.0 / eut);
        return ModifierFunction.builder()
                .inputModifier(ContentModifier.multiplier(parallelAmount))
                .outputModifier(ContentModifier.multiplier(parallelAmount))
                .durationMultiplier(1.25)
                .eutMultiplier(eutMultiplier)
                .parallels(parallelAmount)
                .build();
    }

    @Override
    public void formStructure(@NotNull String substructureName) {
        super.formStructure(substructureName);
        var pState = patternStates.get(substructureName);
        for (var part : getParts()) {
            if (!PartAbility.STEAM.isApplicable(part.self().getDefinition().getBlock())) continue;
            var handlers = part.getRecipeHandlers();
            for (var hl : handlers) {
                if (!hl.isValid(IO.IN)) continue;
                for (var fluidHandler : hl.getCapability(FluidRecipeCapability.CAP)) {
                    if (!(fluidHandler instanceof NotifiableFluidTank nft)) continue;
                    if (nft.isFluidValid(0, GTMaterials.Steam.getFluid(1))) {
                        steamEnergy = new SteamEnergyRecipeHandler(nft, getConversionRate());
                        syncDataHolder.markClientSyncFieldDirty("steamEnergy");
                        addHandlerList(RecipeHandlerList.of(IO.IN, steamEnergy));
                        return;
                    }
                }
            }
        }
        if (steamEnergy == null) { // No steam hatch found
            pState.setError(
                    new PatternStringError(Component.translatable("gtceu.predicate_error.steam.missing_steam_hatch")));
            invalidateStructure(substructureName);
        }
    }

    @Override
    public void buildMainUI(ParentWidget<?> mainWidget, PosGuiData guiData, PanelSyncManager syncManager,
                            UISettings settings) {
        mainWidget.size(170, 76).background(GuiTextures.DISPLAY);

        var listWidget = new ListWidget<>()
                .width(170 - 6)
                .height(76)
                .childSeparator(Icon.EMPTY_2PX)
                .crossAxisAlignment(Alignment.CrossAxis.START)
                .posRel(Alignment.CenterLeft);

        listWidget
                .child(GTMultiblockTextUtil.addUnformedWarning(this, syncManager))
                .child(GTMultiblockTextUtil.addSteamUsageLine(this.steamEnergy, syncManager))
                .child(GTMultiblockTextUtil.addWorkingStatusLine(this, syncManager))
                .child(GTMultiblockTextUtil.addProgressLine(this, syncManager))
                .child(GTMultiblockTextUtil.addParallelLine(this, syncManager))
                .child(GTMultiblockTextUtil.addOutputLines(this, syncManager));

        mainWidget.child(listWidget.left(3).top(3));
    }
}
