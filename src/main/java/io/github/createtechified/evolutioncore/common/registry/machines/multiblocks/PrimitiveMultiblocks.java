package io.github.createtechified.evolutioncore.common.registry.machines.multiblocks;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.multiblock.Predicates;
import com.gregtechceu.gtceu.api.multiblock.pattern.MultiblockPatternBuilder;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.mui.GTGuiTheme;
import com.gregtechceu.gtceu.utils.GTUtil;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.machine.primitive.PrimitiveAlloyKilnMachine;
import io.github.createtechified.evolutioncore.common.registry.EvoTabs;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import static com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection.*;

@SuppressWarnings("unused")
public class PrimitiveMultiblocks {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MAIN);
    }

    public static final MultiblockMachineDefinition PRIMITIVE_ALLOY_KILN = Reference.REGISTRATE
            .multiblock("primitive_alloy_kiln", PrimitiveAlloyKilnMachine::new) // This probably shouldn't be the solution, but it works.
            .rotationState(RotationState.ALL)
            .recipeType(EvoRecipeTypes.PRIMITIVE_ALLOY_SMELTER)
            .appearanceBlock(GTBlocks.CASING_PRIMITIVE_BRICKS)
            .hasBER(true)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice(" BBB ", " BBB ", " BBB ", " BBB ", "  B  ", "     ", "     ")
                    .slice("BBBBB", "BB#BB", "BB#BB", "BB#BB", " B#B ", " BBB ", " BBB ")
                    .slice("BBBBB", "B###B", "B###B", "B###B", "B#B#B", " B&B ", " B#B ")
                    .slice("BBBBB", "BB#BB", "BB#BB", "BB#BB", " B#B ", " BBB ", " BBB ")
                    .slice(" BBB ", " BCB ", " BBB ", " BBB ", "  B  ", "     ", "     ")
                    .where('C', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('B', Predicates.blocks(GTBlocks.CASING_PRIMITIVE_BRICKS.get()))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('&', Predicates.air()
                            .or(Predicates.custom(bws -> GTUtil.isBlockSnow(bws.retrieveCurrentBlockState()) ? null : Predicates.PLACEHOLDER, null)))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_primitive_bricks"), EvolutionCoreMod.id("block/machines/primitive_alloy_kiln"))
            .tooltips(Component.translatable("evolutioncore.tooltip.primitive_alloy_kiln").withStyle(ChatFormatting.GRAY))
            .themeId(GTGuiTheme.PRIMITIVE.getId())
            .register();
}
