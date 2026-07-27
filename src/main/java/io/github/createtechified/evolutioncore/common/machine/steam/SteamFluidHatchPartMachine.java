package io.github.createtechified.evolutioncore.common.machine.steam;

import com.gregtechceu.gtceu.api.blockentity.BlockEntityCreationInfo;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.machine.multiblock.part.FluidHatchPartMachine;
import io.github.createtechified.evolutioncore.common.registry.machines.EvoMultiParts;
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
            newDefinition = EvoMultiParts.STEAM_EXPORT_HATCH;
        } else if (io == IO.OUT) {
            newDefinition = EvoMultiParts.STEAM_IMPORT_HATCH;
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
