package io.github.createtechified.evolutioncore.common.machine.steam;

import com.gregtechceu.gtceu.api.blockentity.BlockEntityCreationInfo;
import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.part.MultiblockPartMachine;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.client.model.machine.MachineRenderState;
import com.gregtechceu.gtceu.common.machine.trait.ExhaustVentMachineTrait;
import com.gregtechceu.gtceu.common.recipe.condition.VentCondition;
import org.jetbrains.annotations.NotNull;

public class SteamMufflerPartMachine extends MultiblockPartMachine {
    private final ExhaustVentMachineTrait exhaustVentTrait;

    public SteamMufflerPartMachine(BlockEntityCreationInfo info) {
        super(info);
        exhaustVentTrait = attachTrait(new ExhaustVentMachineTrait());
        exhaustVentTrait.setVentingDamageAmount(9F);
        MachineRenderState renderState = getRenderState();
        if (renderState.hasProperty(GTMachineModelProperties.VENT_DIRECTION)) {
            setRenderState(renderState.setValue(GTMachineModelProperties.VENT_DIRECTION, RelativeDirection.FRONT));
        }
    }

    @Override
    public void addedToController(@NotNull MultiblockControllerMachine controller, @NotNull String substructureName) {
        super.addedToController(controller, substructureName);
        exhaustVentTrait.setVentingDamageAmount((controller instanceof HPSteamParallelMultiblockMachine) ? 12F : 6F);
        exhaustVentTrait.setVentingDirection(getFrontFacing());
    }

    @Override
    public void afterWorking(@NotNull WorkableMultiblockMachine controller) {
        exhaustVentTrait.afterWorking();
    }

    @Override
    public GTRecipe modifyRecipe(GTRecipe recipe) {
        recipe.conditions.add(VentCondition.INSTANCE);
        return recipe;
    }
}
