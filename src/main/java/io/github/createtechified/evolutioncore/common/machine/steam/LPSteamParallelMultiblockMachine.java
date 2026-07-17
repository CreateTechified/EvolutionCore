package io.github.createtechified.evolutioncore.common.machine.steam;

import brachy.modularui.drawable.Icon;
import brachy.modularui.factory.PosGuiData;
import brachy.modularui.screen.UISettings;
import brachy.modularui.utils.Alignment;
import brachy.modularui.utils.Color;
import brachy.modularui.utils.FormattingUtil;
import brachy.modularui.value.sync.DoubleSyncValue;
import brachy.modularui.value.sync.IntSyncValue;
import brachy.modularui.value.sync.PanelSyncManager;
import brachy.modularui.widget.ParentWidget;
import brachy.modularui.widgets.ListWidget;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.blockentity.BlockEntityCreationInfo;
import com.gregtechceu.gtceu.api.capability.recipe.FluidRecipeCapability;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.machine.feature.IMuiMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.steam.SteamEnergyRecipeHandler;
import com.gregtechceu.gtceu.api.machine.trait.notifiable.NotifiableFluidTank;
import com.gregtechceu.gtceu.api.machine.trait.recipe.RecipeHandlerList;
import com.gregtechceu.gtceu.api.multiblock.error.PatternStringError;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.RecipeHelper;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.mui.GTGuiTextures;
import com.gregtechceu.gtceu.common.mui.GTMultiblockTextUtil;
import com.gregtechceu.gtceu.common.mui.widgets.SteamDialWidget;
import com.gregtechceu.gtceu.config.ConfigHolder;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LPSteamParallelMultiblockMachine extends WorkableMultiblockMachine implements IMuiMachine {

    @Getter
    @Setter
    private int maxParallels;

    @Nullable
    private SteamEnergyRecipeHandler steamEnergy = null;

    public static final double CONVERSION_RATE = 2.0;

    public LPSteamParallelMultiblockMachine(BlockEntityCreationInfo info, int maxParallels) {
        super(info);
        this.maxParallels = maxParallels;
    }

    public LPSteamParallelMultiblockMachine(BlockEntityCreationInfo info) {
        this(info, ConfigHolder.INSTANCE.machines.steamMultiParallelAmount);
    }

    @Override
    public void invalidateStructure(@NotNull String name) {
        super.invalidateStructure(name);
        this.steamEnergy = null;
    }

    @Override
    public void formStructure(@NotNull String substructureName) {
        super.formStructure(substructureName);
        var pState = patternStates.get(substructureName);
        for (var part : getParts()) {
            if (!PartAbility.STEAM.isApplicable(part.getDefinition().getBlock())) continue;
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

    public double getConversionRate() {
        return CONVERSION_RATE;
    }

    public static ModifierFunction recipeModifier(MetaMachine machine, GTRecipe recipe) {
        if (!(machine instanceof LPSteamParallelMultiblockMachine steamMachine)) {
            return RecipeModifier.nullWrongType(LPSteamParallelMultiblockMachine.class, machine);
        }
        if (RecipeHelper.getRecipeEUtTier(recipe) > GTValues.LV) return ModifierFunction.NULL;

        long eut = recipe.getInputEUt().getTotalEU();
        int parallelAmount = ParallelLogic.getParallelAmount(machine, recipe, steamMachine.maxParallels);
        double eutMultiplier = (eut * 0.8888 * parallelAmount <= 32) ? (0.8888 * parallelAmount) : (32.0 / eut);
        return ModifierFunction.builder()
                .inputModifier(ContentModifier.multiplier(parallelAmount))
                .outputModifier(ContentModifier.multiplier(parallelAmount))
                .durationMultiplier(1.5)
                .eutMultiplier(eutMultiplier)
                .parallels(parallelAmount)
                .build();
    }

    @Override
    public void buildMainUI(ParentWidget<?> mainWidget, PosGuiData guiData, PanelSyncManager syncManager,
                            UISettings settings) {
        mainWidget.size(170, 76).background(GTGuiTextures.DISPLAY_BRONZE);
        IntSyncValue steamAmount = syncManager.getOrCreateSyncHandler("steamAmount", IntSyncValue.class,
                () -> new IntSyncValue(() -> steamEnergy == null ? 0 : steamEnergy.getSteamTank().getFluidInTank(0).getAmount()));
        IntSyncValue steamCapacity = syncManager.getOrCreateSyncHandler("steamCapacity", IntSyncValue.class,
                () -> new IntSyncValue(() -> steamEnergy == null ? 0 : steamEnergy.getSteamTank().getTankCapacity(0)));
        DoubleSyncValue steamProgress = syncManager.getOrCreateSyncHandler("steamProgress", DoubleSyncValue.class,
                () -> new DoubleSyncValue(() -> steamEnergy == null ? 0 : steamEnergy.getSteamTank().getFluidInTank(0).getAmount() /
                        (float) steamEnergy.getSteamTank().getTankCapacity(0)));

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

        mainWidget.child(new ParentWidget<>()
                .size(0, 0)
                .child(GTGuiTextures.STEAM_DIAL_BRONZE.asWidget()
                        .size(32, 32)
                        .tooltipAutoUpdate(true)
                        .tooltipDynamic(r -> r.addLine(Component.translatable("gtceu.multiblock.steam.steam_stored",
                                FormattingUtil.formatNumbers(steamAmount.getIntValue()),
                                FormattingUtil.formatNumbers(steamCapacity.getIntValue())))))
                .child(new SteamDialWidget(steamProgress)
                        .setMinAngle((float) Math.PI)
                        .setMaxAngle((float) 0.0f)
                        .setColor(Color.BLACK.brighterSafe(4))
                        .asWidget().decoration()

                        .size(12, 4)
                        .left(16)
                        .top(16)
                        .tooltipAutoUpdate(true)
                        .tooltipDynamic(r -> r.addLine(Component.translatable("gtceu.multiblock.steam.steam_stored",
                                FormattingUtil.formatNumbers(steamAmount.getIntValue()),
                                FormattingUtil.formatNumbers(steamCapacity.getIntValue())))))
                        .leftRelOffset(0.0f, -36).top(4)
                .excludeAreaInRecipeViewer());

        mainWidget.child(listWidget.left(3).top(3));
    }
}

