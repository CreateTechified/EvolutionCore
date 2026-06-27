package io.github.createtechified.evolutioncore.common.registry.machines;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.utils.GTUtil;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.machine.primitive.PrimitiveAlloyKilnMachine;
import io.github.createtechified.evolutioncore.common.registry.CreativeTabs;
import io.github.createtechified.evolutioncore.common.registry.recipes.ModRecipeTypes;

public class GTPrimitiveMultiblocks {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> CreativeTabs.EVOLUTIONCORE_MAIN);
    }

    public static final MultiblockMachineDefinition PRIMITIVE_ALLOY_KILN = Reference.REGISTRATE
            .multiblock("primitive_alloy_kiln", PrimitiveAlloyKilnMachine::new) //This probably shouldn't be the solution, but it works.
            .rotationState(RotationState.ALL)
            .recipeType(ModRecipeTypes.PRIMITIVE_ALLOY_SMELTER)
            .appearanceBlock(GTBlocks.CASING_PRIMITIVE_BRICKS)
            .hasBER(true)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" BBB ", " BBB ", " BBB ", " BBB ", "  B  ", "     ", "     ")
                    .aisle("BBBBB", "BB#BB", "BB#BB", "BB#BB", " B#B ", " BBB ", " BBB ")
                    .aisle("BBBBB", "B###B", "B###B", "B###B", "B#B#B", " B&B ", " B#B ")
                    .aisle("BBBBB", "BB#BB", "BB#BB", "BB#BB", " B#B ", " BBB ", " BBB ")
                    .aisle(" BBB ", " BCB ", " BBB ", " BBB ", "  B  ", "     ", "     ")
                    .where('C', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .where('B', Predicates.blocks(GTBlocks.CASING_PRIMITIVE_BRICKS.get()))
                    .where('#', Predicates.air())
                    .where(' ', Predicates.any())
                    .where('&', Predicates.air()
                            .or(Predicates.custom(bws -> GTUtil.isBlockSnow(bws.getBlockState()), null)))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_primitive_bricks"), GTCEu.id("block/machines/alloy_smelter"))
            .register();
}
