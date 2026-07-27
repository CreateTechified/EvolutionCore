package io.github.createtechified.evolutioncore.common.machine.steam;

import com.gregtechceu.gtceu.api.blockentity.BlockEntityCreationInfo;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.trait.notifiable.NotifiableFluidTank;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.machine.multiblock.part.FluidHatchPartMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidType;

public class SteamFluidHatchPartMachine extends FluidHatchPartMachine {
    public SteamFluidHatchPartMachine(BlockEntityCreationInfo info, IO io) {
        super(info, 0, io, 16 * FluidType.BUCKET_VOLUME, 1);
        circuitSlot.setEnabled(false);
    }

    @Override
    public boolean swapIO() {
        BlockPos blockPos = getBlockPos();
        MachineDefinition newDefinition = null;
        if (io == IO.IN) {
            newDefinition = GTMachines.STEAM_EXPORT_BUS;
        } else if (io == IO.OUT) {
            newDefinition = GTMachines.STEAM_IMPORT_BUS;
        }

        if (newDefinition == null) return false;
        BlockState newBlockState = newDefinition.getBlock().defaultBlockState();

        getLevel().setBlockAndUpdate(blockPos, newBlockState);

        if (getLevel().getBlockEntity(blockPos) instanceof SteamFluidHatchPartMachine newMachine) {
            newMachine.setFrontFacing(this.getFrontFacing());
            newMachine.setUpwardsFacing(this.getUpwardsFacing());
        }
        return true;
    }
}
