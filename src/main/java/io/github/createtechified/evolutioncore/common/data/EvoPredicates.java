package io.github.createtechified.evolutioncore.common.data;

import com.gregtechceu.gtceu.api.machine.multiblock.MultiblockControllerMachine;
import com.gregtechceu.gtceu.api.multiblock.MultiPredicate;
import com.gregtechceu.gtceu.api.multiblock.pattern.PatternState;
import com.gregtechceu.gtceu.api.multiblock.predicates.PredicateBuilder;
import com.gregtechceu.gtceu.api.multiblock.util.BlockInfo;
import com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection;
import io.github.createtechified.evolutioncore.mixin.gt.PredicateContextAccessor;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class EvoPredicates {
    /* For anyone trying to comprehend this,
     * I'm sorry.
     */

    public static MultiPredicate directionalBlock(Block block, RelativeDirection relativeDir) {
        return directionalBlock(block, relativeDir, null, false);
    }

    public static MultiPredicate directionalBlock(Block block, RelativeDirection relativeDir, @Nullable Half half) {
        return directionalBlock(block, relativeDir, half, false);
    }

    public static MultiPredicate directionalBlock(Block block, RelativeDirection relativeDir, boolean invertedFacing) {
        return directionalBlock(block, relativeDir, null, invertedFacing);
    }

    public static MultiPredicate directionalBlock(Block block, RelativeDirection relativeDir, @Nullable Half half, boolean invertedFacing) {
        return new PredicateBuilder("directional_" + block.getDescriptionId())
                .candidates(List.of(BlockInfo.fromBlockState(previewDirState(block, relativeDir, half, invertedFacing))))
                .predicate(ctx -> {
                    PatternState pstate = Objects.requireNonNull(((PredicateContextAccessor) ctx).evoc$getPatternState());
                    MultiblockControllerMachine controller = Objects.requireNonNull(pstate.getController());
                    BlockState state = ctx.state();
                    if (!state.is(block)) return false;

                    if (half != null) {
                        if (!state.hasProperty(BlockStateProperties.HALF)) return false;
                        Half expectedHalf = halfHandler(half, controller.getUpwardsFacing());
                        if (state.getValue(BlockStateProperties.HALF) != expectedHalf) return false;
                    }

                    Direction facing = Objects.requireNonNull(getFacing(state));
                    if (invertedFacing) facing = facing.getOpposite(); // Some blocks PISS ME OFF. thanks.

                    Direction controllerFacing = controller.getFrontFacing();
                    Direction targetDirection = relativeDir.applyDirection(controllerFacing);

                    return facing == targetDirection;
                })
                .toMultiPredicate();
    }

    public static MultiPredicate halfBlock(Block block, Half half) {
        return new PredicateBuilder("half_" + block.getDescriptionId())
                .candidates(List.of(BlockInfo.fromBlockState(previewHalfState(block, half))))
                .predicate(ctx -> {
                    PatternState pstate = Objects.requireNonNull(((PredicateContextAccessor) ctx).evoc$getPatternState());
                    BlockState state = ctx.state();
                    if (!state.is(block)) return false;
                    if (!state.hasProperty(BlockStateProperties.HALF)) return false;

                    MultiblockControllerMachine controller = Objects.requireNonNull(pstate.getController());
                    Half expectedHalf = halfHandler(half, controller.getUpwardsFacing());
                    return state.getValue(BlockStateProperties.HALF) == expectedHalf;
                })
                .toMultiPredicate();
    }

    private static Direction getFacing(BlockState state) {
        if (state.hasProperty(BlockStateProperties.FACING)) {
            return state.getValue(BlockStateProperties.FACING);
        }
        if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
            return state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        }
        return null;
    }

    private static BlockState previewDirState(Block block, RelativeDirection relativeDir, @Nullable Half half, boolean invertedFacing) {
        Direction previewControllerFacing = Direction.NORTH;
        Direction previewUpwardsFacing = Direction.UP;
        Direction target = relativeDir.applyDirection(previewControllerFacing);
        if (invertedFacing) target = target.getOpposite();

        BlockState state = block.defaultBlockState();
        if (state.hasProperty(BlockStateProperties.FACING)) {
            state = state.setValue(BlockStateProperties.FACING, target);
        } else if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
            state = state.setValue(BlockStateProperties.HORIZONTAL_FACING, target);
        }
        if (half != null && state.hasProperty(BlockStateProperties.HALF)) {
            state = state.setValue(BlockStateProperties.HALF, halfHandler(half, previewUpwardsFacing));
        }
        return state;
    }

    private static BlockState previewHalfState(Block block, Half half) {
        Direction previewUpwardsFacing = Direction.UP;
        BlockState previewState = block.defaultBlockState();
        if (previewState.hasProperty(BlockStateProperties.HALF)) {
            previewState = previewState.setValue(BlockStateProperties.HALF, halfHandler(half, previewUpwardsFacing));
        }
        return previewState;
    }

    private static Half halfHandler(Half half, Direction upwardsFacing) {
        return upwardsFacing == Direction.DOWN ? flip(half) : half;
    }

    private static Half flip(Half half) {
        return half == Half.TOP ? Half.BOTTOM : Half.TOP;
    }
}
