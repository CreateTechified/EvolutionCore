package io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.electric;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.CoilWorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.multiblock.Predicates;
import com.gregtechceu.gtceu.api.multiblock.pattern.MultiblockPatternBuilder;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.common.data.*;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.EvoBlocks;
import io.github.createtechified.evolutioncore.common.registry.EvoTabs;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import static com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection.*;

public class UpgradeMultiblocks {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MAIN);
    }

    public static final MultiblockMachineDefinition LARGE_CHEMICAL_PLANT = Reference.REGISTRATE
            .multiblock("large_chemical_plant", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GCYMBlocks.CASING_HIGH_TEMPERATURE_SMELTING)
            .recipeTypes(GTRecipeTypes.CHEMICAL_RECIPES, GTRecipeTypes.LARGE_CHEMICAL_RECIPES, EvoRecipeTypes.LARGE_CHEMICAL_PLANT, EvoRecipeTypes.CHEMICAL_LINE_REDUCTION)
            .recipeModifiers(GTRecipeModifiers.PARALLEL_HATCH, GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK))
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice("CCCCCCCCCCCCCCC", " CVVVCVVVCVVVC ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .slice("CCCCCCCCCCCCCCC", "CTTTTTTTTTTTTTC", "  TTT TTT TTT  ", "               ", "               ", "               ", "               ", "               ")
                    .slice("CCCCCCCCCCCCCCC", "VTPPPTPPPTPPPTV", " TPPPTPPPTPPPT ", "  PPP PPP PPP  ", "  PPP PPP PPP  ", "  PPP PPP PPP  ", "  PPP PPP PPP  ", "  PPP PPP PPP  ")
                    .slice("CCCCCCCCCCCCCCC", "VTPPPTPPPTPPPTV", " TP#PTP#PTP#PT ", "  P#P P#P P#P  ", "  P#P P#P P#P  ", "  P#P P#P P#P  ", "  P#P P#P P#P  ", "  PMP PMP PMP  ")
                    .slice("CCCCCCCCCCCCCCC", "VTPPPTPPPTPPPTV", " TPPPTPPPTPPPT ", "  PPP PPP PPP  ", "  PPP PPP PPP  ", "  PPP PPP PPP  ", "  PPP PPP PPP  ", "  PPP PPP PPP  ")
                    .slice("CCCCCCCCCCCCCCC", "CTTTTTTTTTTTTTC", "  TTT TTT TTT  ", "               ", "               ", "               ", "               ", "               ")
                    .slice("CCCCCCCCCCCCCCC", " CVVVVC@CVVVVC ", "               ", "               ", "               ", "               ", "               ", "               ")
                    .where('@', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('#', Predicates.air())
                    .where('C', Predicates.blocks(GCYMBlocks.CASING_HIGH_TEMPERATURE_SMELTING.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.PARALLEL_HATCH).setMaxGlobalLimited(1).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(6).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMaxGlobalLimited(6).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(6).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setMaxGlobalLimited(6).setPreviewCount(1)))
                    .where('V', Predicates.blocks(GCYMBlocks.HEAT_VENT.get()))
                    .where('P', Predicates.blocks(GCYMBlocks.CASING_CORROSION_PROOF.get()))
                    .where('M', Predicates.abilities(PartAbility.MUFFLER).setExactLimit(3))
                    .where('T', Predicates.blocks(GCYMBlocks.CASING_HIGH_TEMPERATURE_SMELTING.get()))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/gcym/high_temperature_smelting_casing"), GTCEu.id("block/multiblock/large_chemical_reactor"))
            .langValue("Large Chemical Plant")
            .tooltips(Component.translatable("evolutioncore.tooltip.large_chemical_plant").withStyle(ChatFormatting.GRAY))
            .register();

    public static final MultiblockMachineDefinition FUSION_ALLOYING_CHAMBER = Reference.REGISTRATE
            .multiblock("fusion_alloying_chamber", CoilWorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GCYMBlocks.CASING_HIGH_TEMPERATURE_SMELTING)
            .recipeType(GCYMRecipeTypes.ALLOY_BLAST_RECIPES)
            .recipeModifiers(GTRecipeModifiers.PARALLEL_HATCH, GTRecipeModifiers::ebfOverclock)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice(" CCCCC ", " FCCCF ", " F C F ", " F   F ", "       ", "       ", "       ", " F   F ", " F C F ", " FCCCF ", " CCCCC ")
                    .slice("CCCCCCC", "FCCCCCF", "FHHHHHF", "FHHHHHF", " F H F ", " F   F ", " F H F ", "FHHHHHF", "FHHHHHF", "FCCCCCF", "CCCCCCC")
                    .slice("CCIIICC", "CCCCCCC", " H###H ", " H###H ", "  V#V  ", "  VVV  ", "  V#V  ", " H###H ", " H###H ", "CCCCCCC", "CCIIICC")
                    .slice("CCIIICC", "CCCCCCC", "CH###HC", " H###H ", " H###H ", "  V#V  ", " H###H ", " H###H ", "CH###HC", "CCCCCCC", "CCIMICC")
                    .slice("CCIIICC", "CCCCCCC", " H###H ", " H###H ", "  V#V  ", "  VVV  ", "  V#V  ", " H###H ", " H###H ", "CCCCCCC", "CCIIICC")
                    .slice("CCCCCCC", "FCCCCCF", "FHHHHHF", "FHHHHHF", " F H F ", " F   F ", " F H F ", "FHHHHHF", "FHHHHHF", "FCCCCCF", "CCCCCCC")
                    .slice(" CCCCC ", " FC@CF ", " F C F ", " F   F ", "       ", "       ", "       ", " F   F ", " F C F ", " FCCCF ", " CCCCC ")
                    .where('@', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('#', Predicates.air())
                    .where('C', Predicates.blocks(GCYMBlocks.CASING_HIGH_TEMPERATURE_SMELTING.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.PARALLEL_HATCH).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setMaxGlobalLimited(9))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(3))
                            .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS).setExactLimit(1)))
                    .where('V', Predicates.blocks(GCYMBlocks.HEAT_VENT.get()))
                    .where('F', Predicates.frames(GTMaterials.NaquadahAlloy))
                    .where('I', Predicates.blocks(EvoBlocks.LUDICROUS_ENGINE_INTAKE_CASING.get()))
                    .where('H', Predicates.heatingCoils())
                    .where('M', Predicates.abilities(PartAbility.MUFFLER).setExactLimit(1))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/gcym/high_temperature_smelting_casing"), GTCEu.id("block/multiblock/gcym/blast_alloy_smelter"))
            .langValue("Fusion Alloying Chamber")
            .tooltips(Component.translatable("evolutioncore.tooltip.fusion_alloying_chamber").withStyle(ChatFormatting.WHITE))
            .register();
}
