package io.github.createtechified.evolutioncore.common.machine.steam;

import com.gregtechceu.gtceu.api.blockentity.BlockEntityCreationInfo;
import com.gregtechceu.gtceu.api.machine.feature.IMufflableMachine;
import com.gregtechceu.gtceu.api.machine.feature.multiblock.IWorkableMultiController;
import com.gregtechceu.gtceu.api.machine.multiblock.part.MultiblockPartMachine;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection;
import com.gregtechceu.gtceu.client.model.machine.MachineRenderState;
import com.gregtechceu.gtceu.common.machine.trait.ExhaustVentMachineTrait;
import lombok.Getter;
import lombok.Setter;

public class SteamMufflerPartMachine extends MultiblockPartMachine {
    private final ExhaustVentMachineTrait exhaustVentTrait;

    public SteamMufflerPartMachine(BlockEntityCreationInfo info) {
        super(info);
        this.exhaustVentTrait = attachTrait(new ExhaustVentMachineTrait());
        exhaustVentTrait.setVentingDamageAmount(9F);
        MachineRenderState renderState = getRenderState();
        if (renderState.hasProperty(GTMachineModelProperties.VENT_DIRECTION)) {
            setRenderState(renderState.setValue(GTMachineModelProperties.VENT_DIRECTION, RelativeDirection.FRONT));
        }
    }
}
