package io.github.createtechified.evolutioncore.common.registry.machines.multiblocks;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.multiblock.Predicates;
import com.gregtechceu.gtceu.api.multiblock.pattern.MultiblockPatternBuilder;
import com.gregtechceu.gtceu.client.renderer.machine.DynamicRenderHelper;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.models.GTMachineModels;
import com.gregtechceu.gtceu.common.mui.GTGuiTheme;
import com.gregtechceu.gtceu.utils.GTUtil;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.machine.primitive.PrimitiveAlloyKilnMachine;
import io.github.createtechified.evolutioncore.common.machine.primitive.PrimitiveOreFactoryMachine;
import io.github.createtechified.evolutioncore.common.registry.EvoTabs;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Blocks;

import static com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection.*;

@SuppressWarnings("unused")
public class PrimitiveMultiblocks {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MAIN);
    }

    public static final MultiblockMachineDefinition PRIMITIVE_ALLOY_KILN = Reference.REGISTRATE
            .multiblock("primitive_alloy_kiln", PrimitiveAlloyKilnMachine::new) // It's a thing and I'm pissed about it. Works though.
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EvoRecipeTypes.PRIMITIVE_ALLOY_SMELTER)
            .appearanceBlock(GTBlocks.CASING_PRIMITIVE_BRICKS)
            .hasBER(true)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice(" BBB ", " BBB ", " BBB ", " BBB ", "  B  ", "     ", "     ")
                    .slice("BBBBB", "BB#BB", "BB#BB", "BB#BB", " B#B ", " BBB ", " BBB ")
                    .slice("BBBBB", "B###B", "B###B", "B###B", "B#B#B", " B&B ", " B#B ")
                    .slice("BBBBB", "BB#BB", "BB#BB", "BB#BB", " B#B ", " BBB ", " BBB ")
                    .slice(" BBB ", " BCB ", " BBB ", " BBB ", "  B  ", "     ", "     ")
                    .where('C', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('B', Predicates.blocks(GTBlocks.CASING_PRIMITIVE_BRICKS.get()))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('&', Predicates.air()
                            .or(Predicates.custom(bws -> GTUtil.isBlockSnow(bws.retrieveCurrentBlockState()) ? null : Predicates.PLACEHOLDER, null)))
                    .build())
            .model(GTMachineModels.createWorkableCasingMachineModel(GTCEu.id("block/casings/solid/machine_primitive_bricks"),
                            EvolutionCoreMod.id("block/machines/primitive_alloy_kiln"))
                    .andThen(b -> b.addDynamicRenderer(DynamicRenderHelper::createPBFLavaRender)))
            .tooltips(Component.translatable("evolutioncore.tooltip.primitive_alloy_kiln").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.PRIMITIVE.getId())
            .register();

    public static final MultiblockMachineDefinition PRIMITIVE_ORE_FACTORY = Reference.REGISTRATE
            .multiblock("primitive_ore_factory", PrimitiveOreFactoryMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .recipeType(EvoRecipeTypes.PRIMITIVE_ORE_FACTORY)
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
                    .where('C', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('B', Predicates.blocks(GTBlocks.CASING_PRIMITIVE_BRICKS.get()))
                    .where('G', Predicates.blocks(Blocks.GLASS))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('&', Predicates.air()
                            .or(Predicates.custom(bws -> GTUtil.isBlockSnow(bws.retrieveCurrentBlockState()) ? null : Predicates.PLACEHOLDER, null)))
                    .build())
            .model(GTMachineModels.createWorkableCasingMachineModel(GTCEu.id("block/casings/solid/machine_primitive_bricks"),
                            GTCEu.id("block/multiblock/primitive_blast_furnace"))
                    .andThen(b -> b.addDynamicRenderer(DynamicRenderHelper::createPBFLavaRender)))
            .tooltips(Component.translatable("evolutioncore.tooltip.primitive_ore_factory").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.PRIMITIVE.getId())
            .register();
}
