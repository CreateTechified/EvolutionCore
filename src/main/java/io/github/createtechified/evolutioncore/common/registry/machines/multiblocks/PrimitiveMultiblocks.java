package io.github.createtechified.evolutioncore.common.registry.machines.multiblocks;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.multiblock.Predicates;
import com.gregtechceu.gtceu.api.multiblock.pattern.MultiblockPatternBuilder;
import com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection;
import com.gregtechceu.gtceu.client.renderer.machine.DynamicRenderHelper;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import com.gregtechceu.gtceu.common.mui.GTGuiTheme;
import com.gregtechceu.gtceu.utils.GTUtil;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.data.EvoPredicates;
import io.github.createtechified.evolutioncore.common.data.machine.primitive.PrimitiveAlloyKiln;
import io.github.createtechified.evolutioncore.common.data.machine.primitive.PrimitiveOreFactory;
import io.github.createtechified.evolutioncore.common.registry.EvoBlocks;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeModifiers;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import static com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection.*;
import static net.minecraft.world.level.block.state.properties.Half.*;

@SuppressWarnings("unused")
public class PrimitiveMultiblocks {
    public static void init() {
        coke_oven();
        primitive_blast_furnace();
    }

    public static void coke_oven() {
        GTMultiMachines.COKE_OVEN.setPattern("main", () -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                .slice("XXX", "XXX", "BBB", "   ", "   ", "   ")
                .slice("XXX", "XXX", "XXX", "WXW", "WXW", "XUX")
                .slice("XXX", "X#X", "XXX", "XXX", "XXX", "LXR")
                .slice("XXX", "XYX", "XXX", "WXW", "WXW", "XDX")
                .where('Y', Predicates.controller(GTMultiMachines.COKE_OVEN))
                .where('X', Predicates.blocks(GTBlocks.CASING_COKE_BRICKS.get()).and(Predicates.blocks(GTMachines.COKE_OVEN_HATCH.get()).setMaxGlobalLimited(5)))
                .where('B', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), BACK, BOTTOM, true))
                .where('U', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), BACK, TOP, true))
                .where('L', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), LEFT, TOP, true))
                .where('R', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), RIGHT, TOP, true))
                .where('D', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), FRONT, TOP, true))
                .where('W', Predicates.blocks(EvoBlocks.CASING_COKE_BRICK_WALL.get())) // ^ I have commit horrors that would disappoint my ancestors.
                .where('#', Predicates.air())
                .where(' ', Predicates.any())
                .build());
    }
    public static void primitive_blast_furnace() {
        GTMultiMachines.PRIMITIVE_BLAST_FURNACE.setPattern("main", () -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                .slice("BUUUB", "     ", "     ", "     ", "     ", "     ")
                .slice("LBBBR", " XIX ", " XXX ", " PXP ", " PXP ", " XIX ")
                .slice("LBBBR", " JXO ", " X&X ", " X#X ", " X#X ", " J#O ")
                .slice("LBBBR", " XKX ", " XYX ", " PXP ", " PXP ", " XKX ")
                .slice("BDDDB", "     ", "     ", "     ", "     ", "     ")
                .where('Y', Predicates.controller(GTMultiMachines.PRIMITIVE_BLAST_FURNACE))
                .where('X', Predicates.blocks(GTBlocks.CASING_PRIMITIVE_BRICKS.get()))
                .where('B', Predicates.blocks(GTBlocks.CASING_COKE_BRICKS.get()))
                .where('U', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), BACK, BOTTOM, true))
                .where('L', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), LEFT, BOTTOM, true))
                .where('R', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), RIGHT, BOTTOM, true))
                .where('D', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), FRONT, BOTTOM, true))
                .where('I', EvoPredicates.directionalBlock(EvoBlocks.CASING_PRIMITIVE_BRICK_STAIRS.get(), BACK, TOP, true))
                .where('J', EvoPredicates.directionalBlock(EvoBlocks.CASING_PRIMITIVE_BRICK_STAIRS.get(), LEFT, TOP, true))
                .where('O', EvoPredicates.directionalBlock(EvoBlocks.CASING_PRIMITIVE_BRICK_STAIRS.get(), RIGHT, TOP, true))
                .where('K', EvoPredicates.directionalBlock(EvoBlocks.CASING_PRIMITIVE_BRICK_STAIRS.get(), FRONT, TOP, true))
                .where('P', Predicates.blocks(EvoBlocks.CASING_PRIMITIVE_BRICK_WALL.get()))
                .where('#', Predicates.air())
                .where('&', Predicates.air()
                        .or(Predicates.builder("SnowPredicate")
                                .predicate(ctx -> GTUtil.isBlockSnow(ctx.state()))
                                .toMultiPredicate()
                                .addTooltips(Component.literal("Can be snow"))))
                .build());
    }

    public static final MultiblockMachineDefinition PRIMITIVE_ALLOY_KILN = Reference.REGISTRATE
            .multiblock("primitive_alloy_kiln", PrimitiveAlloyKiln::new) // It's a thing and I'm pissed about it. Works though.
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EvoRecipeTypes.PRIMITIVE_ALLOY_SMELTER)
            .recipeModifiers(EvoRecipeModifiers::primitiveFuel)
            .appearanceBlock(GTBlocks.CASING_PRIMITIVE_BRICKS)
            .hasBER(true)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice(" BBB ", " BBB ", " BBB ", " BBB ", "  B  ", "     ", "     ")
                    .slice("BBBBB", "BB#BB", "BB#BB", "BB#BB", " B#B ", " BBB ", " BBB ")
                    .slice("BBBBB", "B###B", "B###B", "B###B", "B#B#B", " B&B ", " B#B ")
                    .slice("BBBBB", "BB#BB", "BB#BB", "BB#BB", " B#B ", " BBB ", " BBB ")
                    .slice(" BBB ", " BCB ", " BBB ", " BBB ", "  B  ", "     ", "     ")
                    .where('C', Predicates.controller(definition))
                    .where('B', Predicates.blocks(GTBlocks.CASING_PRIMITIVE_BRICKS.get()))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('&', Predicates.air()
                            .or(Predicates.builder("SnowPredicate")
                                    .predicate(ctx -> GTUtil.isBlockSnow(ctx.state()))
                                    .toMultiPredicate()
                                    .addTooltips(Component.literal("Can be snow"))))
                    .build())
            .model(GTMachineModels.createWorkableCasingMachineModel(GTCEu.id("block/casings/solid/machine_primitive_bricks"),
                            EvolutionCoreMod.id("block/machines/primitive_alloy_kiln"))
                    .andThen(b -> b.addDynamicRenderer(DynamicRenderHelper::createPBFLavaRender)))
            .tooltips(Component.translatable("evolutioncore.tooltip.primitive_alloy_kiln").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.PRIMITIVE.getId())
            .register();
    public static final MultiblockMachineDefinition PRIMITIVE_ORE_FACTORY = Reference.REGISTRATE
            .multiblock("primitive_ore_factory", PrimitiveOreFactory::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EvoRecipeTypes.PRIMITIVE_ORE_FACTORY)
            .recipeModifiers(EvoRecipeModifiers::primitiveFuel)
            .appearanceBlock(GTBlocks.CASING_PRIMITIVE_BRICKS)
            .hasBER(true)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice("  BBB  ", "  BBB  ", "  BGB  ", "  BGB  ", "  BGB  ", "  BBB  ", "       ", "       ", "       ", "       ")
                    .slice(" BBBBB ", " BBBBB ", " G###G ", " G###G ", " B###B ", " B###B ", " BBGBB ", "  BBB  ", "       ", "       ")
                    .slice("BBBBBBB", "BB###BB", "B#####B", "B#####B", "B#####B", "B#####B", " B###B ", " B###B ", "  BBB  ", "  BBB  ")
                    .slice("BBBBBBB", "BB#B#BB", "G##B##G", "G##B##G", "G##B##G", "B##B##B", " G#B#G ", " B#B#B ", "  B&B  ", "  B B  ")
                    .slice("BBBBBBB", "BB###BB", "B#####B", "B#####B", "B#####B", "B#####B", " B###B ", " B###B ", "  BBB  ", "  BBB  ")
                    .slice(" BBBBB ", " BBBBB ", " G###G ", " G###G ", " B###B ", " B###B ", " BBGBB ", "  BBB  ", "       ", "       ")
                    .slice("  BBB  ", "  BCB  ", "  BGB  ", "  BGB  ", "  BGB  ", "  BBB  ", "       ", "       ", "       ", "       ")
                    .where('C', Predicates.controller(definition))
                    .where('B', Predicates.blocks(GTBlocks.CASING_PRIMITIVE_BRICKS.get()))
                    .where('G', Predicates.blocks(Blocks.GLASS))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('&', Predicates.air()
                            .or(Predicates.builder("SnowPredicate")
                                    .predicate(ctx -> GTUtil.isBlockSnow(ctx.state()))
                                    .toMultiPredicate()
                                    .addTooltips(Component.literal("Can be snow"))))
                    .build())
            .model(GTMachineModels.createWorkableCasingMachineModel(GTCEu.id("block/casings/solid/machine_primitive_bricks"),
                            GTCEu.id("block/multiblock/primitive_blast_furnace"))
                    .andThen(b -> b.addDynamicRenderer(DynamicRenderHelper::createPBFLavaRender)))
            .tooltips(Component.translatable("evolutioncore.tooltip.primitive_ore_factory").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.PRIMITIVE.getId())
            .register();
}
