package io.github.createtechified.evolutioncore.common.registry.machines;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import com.gregtechceu.gtceu.utils.GTUtil;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.machine.primitive.PrimitiveAlloyKilnMachine;
import io.github.createtechified.evolutioncore.common.registry.CreativeTabs;
import io.github.createtechified.evolutioncore.common.registry.recipes.ModRecipeTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class GTMultiblocks {
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
            .tooltips(Component.translatable("evolutioncore.tooltip.primitive_alloy_kiln").withStyle(ChatFormatting.GRAY))
            .register();

    public static final MultiblockMachineDefinition STEAM_ALLOY_KILN = Reference.REGISTRATE
            .multiblock("steam_alloy_kiln", (holder) -> new SteamParallelMultiblockMachine(holder, 4))
            .rotationState(RotationState.ALL)
            .recipeType(GTRecipeTypes.ALLOY_SMELTER_RECIPES)
            .recipeModifier(SteamParallelMultiblockMachine::recipeModifier, true)
            .appearanceBlock(GTBlocks.CASING_BRONZE_BRICKS)
            .pattern(definition -> FactoryBlockPattern.start()
                    .aisle(" FFF ", " MMM ", " MMM ", " MMM ", "  M  ", "     ", "     ")
                    .aisle("FMMMF", "MG#GM", "M###M", "M###M", " M#M ", " MMM ", " BBB ")
                    .aisle("FMMMF", "M#P#M", "M#P#M", "M#P#M", "M#P#M", " M M ", " B B ")
                    .aisle("FMMMF", "MG#GM", "M###M", "M###M", " M#M ", " MMM ", " BBB ")
                    .aisle(" FFF ", " MCM ", " MMM ", " MMM ", "  M  ", "     ", "     ")
                    .where('C', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('#', Predicates.air())
                    .where('M', Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(30)
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1).setMaxGlobalLimited(2))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1).setMaxGlobalLimited(2)))
                    .where('P', Predicates.blocks(GTBlocks.CASING_BRONZE_PIPE.get()))
                    .where('G', Predicates.blocks(GTBlocks.CASING_BRONZE_GEARBOX.get()))
                    .where('F', Predicates.blocks(GTBlocks.FIREBOX_BRONZE.get()))
                    .where('B', Predicates.blocks(GTBlocks.BRONZE_HULL.get()))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"), GTCEu.id("block/machines/alloy_smelter"))
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_alloy_kiln").withStyle(ChatFormatting.GRAY))
            .register();
}
