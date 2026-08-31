package io.github.createtechified.evolutioncore.mixin.gt;

import com.gregtechceu.gtceu.api.block.MetaMachineBlock;
import com.gregtechceu.gtceu.api.multiblock.pattern.IBlockPattern;
import com.gregtechceu.gtceu.api.multiblock.util.AbstractStructureHelper;
import com.gregtechceu.gtceu.api.multiblock.util.BlockInfo;
import io.github.createtechified.evolutioncore.common.data.EvoPredicates;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.Map;

@Mixin(AbstractStructureHelper.class)
public class AbstractStructureHelperMixin {
    @Inject(method = "populate", at = @At("TAIL"))
    @SuppressWarnings("deprecation")
    private void evoc$fixDirectionalStates(Map<BlockPos, BlockInfo> resultStructure, IBlockPattern pattern,
                                           @Nullable Long2ObjectMap<BlockInfo> userBlockPreferences,
                                           Direction frontFacing, Direction upFacing, boolean isFlipped,
                                           CallbackInfo ci) {
        Rotation rotation = evoc$rotationFromNorth(frontFacing);
        Mirror mirror = isFlipped ? Mirror.FRONT_BACK : Mirror.NONE;

        Map<BlockPos, BlockState> toUpdate = new Object2ObjectOpenHashMap<>();
        for (var entry : resultStructure.entrySet()) {
            BlockState state = entry.getValue().getBlockState();
            if (state.getBlock() instanceof MetaMachineBlock) continue;
            boolean hasFacing = state.hasProperty(BlockStateProperties.FACING)
                    || state.hasProperty(BlockStateProperties.HORIZONTAL_FACING);
            boolean isHalfAware = EvoPredicates.HALF_AWARE_CANDIDATES.contains(state);
            if (!hasFacing && !isHalfAware) continue;
            BlockState newState = hasFacing ? state.mirror(mirror).rotate(rotation) : state;
            if (isHalfAware && upFacing == Direction.DOWN && newState.hasProperty(BlockStateProperties.HALF)) {
                Half current = newState.getValue(BlockStateProperties.HALF);
                newState = newState.setValue(BlockStateProperties.HALF, EvoPredicates.flip(current));
            }
            toUpdate.put(entry.getKey(), newState);
        }
        toUpdate.forEach((pos, state) -> resultStructure.put(pos, BlockInfo.fromBlockState(state)));
    }

    @Unique
    private static Rotation evoc$rotationFromNorth(Direction facing) {
        return switch (facing) {
            case NORTH -> Rotation.NONE;
            case EAST -> Rotation.CLOCKWISE_90;
            case SOUTH -> Rotation.CLOCKWISE_180;
            case WEST -> Rotation.COUNTERCLOCKWISE_90;
            default -> throw new IllegalStateException("Controller facing must be horizontal: " + facing);
        };
    }
}