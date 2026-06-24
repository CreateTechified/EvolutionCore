package io.github.createtechified.evolutioncore.common.data.machines;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.client.renderer.machine.DynamicRenderHelper;
import com.gregtechceu.gtceu.common.data.*;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import com.gregtechceu.gtceu.utils.GTUtil;
import io.github.createtechified.evolutioncore.common.registry.recipes.ModRecipeTypes;

import static com.gregtechceu.gtceu.api.pattern.Predicates.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;
import static com.gregtechceu.gtceu.common.data.models.GTMachineModels.*;
import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class PJEVOMultiMachines {
    public static final MultiblockMachineDefinition PRIMITIVE_ALLOY_KILN = REGISTRATE
            .multiblock("primitive_alloy_kiln", (holder) -> new SteamParallelMultiblockMachine(holder, 4))
            .rotationState(RotationState.ALL)
            .recipeType(ModRecipeTypes.PRIMITIVE_ALLOY_SMELTER)
            .model(createWorkableCasingMachineModel(GTCEu.id("block/casings/solid/machine_primitive_bricks"),
                    GTCEu.id("block/machines/alloy_smelter"))
                    .andThen(b -> b.addDynamicRenderer(DynamicRenderHelper::createPBFLavaRender)))
            .appearanceBlock(CASING_PRIMITIVE_BRICKS)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" BBB ", " BBB ", " BBB ", " BBB ", "  B  ", "     ", "     ")
                    .aisle("BBBBB", "BB#BB", "BB#BB", "BB#BB", " B#B ", " BBB ", " BBB ")
                    .aisle("BBBBB", "B###B", "B###B", "B###B", "B#B#B", " B B ", " B B ")
                    .aisle("BBBBB", "BB#BB", "BB#BB", "BB#BB", " B#B ", " BBB ", " BBB ")
                    .aisle(" BBB ", " B@B ", " BBB ", " BBB ", "  B  ", "     ", "     ")
                    .where('C', controller(blocks(definition.getBlock())))
                    .where('B', blocks(CASING_PRIMITIVE_BRICKS.get()))
                    .where('#', air())
                    .where(' ', any())
                    .build())
            .register();
}