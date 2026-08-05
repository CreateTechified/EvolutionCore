package io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.electric;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.multiblock.Predicates;
import com.gregtechceu.gtceu.api.multiblock.pattern.MultiblockPatternBuilder;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.EvoBlocks;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import static com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection.*;

public class OreProcessingMultiblocks {
    public static void init() {}

    public static final MultiblockMachineDefinition ELECTRIC_ORE_FACTORY = Reference.REGISTRATE
            .multiblock("electric_ore_factory", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.CASING_STEEL_SOLID)
            .recipeType(EvoRecipeTypes.ELECTRIC_ORE_FACTORY)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice("  FFF  ", "  CCC  ", "  CVC  ", "  CVC  ", "  CVC  ", "  CCC  ", "       ", "       ", "       ", "       ")
                    .slice(" FCCCF ", " CGGGC ", " V###V ", " V###V ", " C###C ", " C###C ", " CCVCC ", "  CCC  ", "       ", "       ")
                    .slice("FCCCCCF", "CG###GC", "C#####C", "C#####C", "C#####C", "C#####C", " C###C ", " C###C ", "  CCC  ", "  BBB  ")
                    .slice("FCCCCCF", "CG#P#GC", "V##P##V", "V##P##V", "V##P##V", "C##P##C", " V#P#V ", " C#P#C ", "  CMC  ", "  B B  ")
                    .slice("FCCCCCF", "CG###GC", "C#####C", "C#####C", "C#####C", "C#####C", " C###C ", " C###C ", "  CCC  ", "  BBB  ")
                    .slice(" FCCCF ", " CGGGC ", " V###V ", " V###V ", " C###C ", " C###C ", " CCVCC ", "  CCC  ", "       ", "       ")
                    .slice("  FFF  ", "  C@C  ", "  CVC  ", "  CVC  ", "  CVC  ", "  CCC  ", "       ", "       ", "       ", "       ")
                    .where('@', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('#', Predicates.air())
                    .where('C', Predicates.blocks(GTBlocks.CASING_STEEL_SOLID.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1).setMaxGlobalLimited(6).setPreviewCount(6))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setExactLimit(1)))
                    .where('M', Predicates.abilities(PartAbility.MUFFLER))
                    .where('P', Predicates.blocks(GTBlocks.CASING_STEEL_PIPE.get()))
                    .where('G', Predicates.blocks(GTBlocks.CASING_STEEL_GEARBOX.get()))
                    .where('F', Predicates.blocks(GTBlocks.FIREBOX_STEEL.get()))
                    .where('V', Predicates.blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
                    .where('B', Predicates.blocks(GTBlocks.STEEL_HULL.get()))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_solid_steel"), EvolutionCoreMod.id("block/machines/ore_processing_factory"))
            .langValue("Electric Ore Factory")
            .tooltips(Component.translatable("evolutioncore.tooltip.electric_ore_factory").withStyle(ChatFormatting.GRAY))
            .register();

    public static final MultiblockMachineDefinition ORE_PROCESSING_FACTORY = Reference.REGISTRATE
            .multiblock("ore_processing_factory", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.CASING_STAINLESS_CLEAN)
            .recipeType(EvoRecipeTypes.ELECTRIC_ORE_FACTORY)
            .recipeModifiers(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK))
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice("  FFF  ", "  CCC  ", "  CVC  ", "  CVC  ", "  CVC  ", "  CCC  ", "       ", "       ", "       ", "       ")
                    .slice(" FCCCF ", " CGGGC ", " V###V ", " V###V ", " C###C ", " C###C ", " CCVCC ", "  CCC  ", "       ", "       ")
                    .slice("FCCCCCF", "CG###GC", "C#####C", "C#####C", "C#####C", "C#####C", " C###C ", " C###C ", "  CCC  ", "  BBB  ")
                    .slice("FCCCCCF", "CG#P#GC", "V##P##V", "V##P##V", "V##P##V", "C##P##C", " V#P#V ", " C#P#C ", "  CMC  ", "  B B  ")
                    .slice("FCCCCCF", "CG###GC", "C#####C", "C#####C", "C#####C", "C#####C", " C###C ", " C###C ", "  CCC  ", "  BBB  ")
                    .slice(" FCCCF ", " CGGGC ", " V###V ", " V###V ", " C###C ", " C###C ", " CCVCC ", "  CCC  ", "       ", "       ")
                    .slice("  FFF  ", "  C@C  ", "  CVC  ", "  CVC  ", "  CVC  ", "  CCC  ", "       ", "       ", "       ", "       ")
                    .where('@', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('#', Predicates.air())
                    .where('C', Predicates.blocks(GTBlocks.CASING_STAINLESS_CLEAN.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1).setMaxGlobalLimited(6).setPreviewCount(6))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setExactLimit(1)))
                    .where('M', Predicates.abilities(PartAbility.MUFFLER))
                    .where('P', Predicates.blocks(EvoBlocks.STAINLESS_STEEL_PIPE_CASING.get()))
                    .where('G', Predicates.blocks(GTBlocks.CASING_STAINLESS_STEEL_GEARBOX.get()))
                    .where('F', Predicates.blocks(EvoBlocks.STAINLESS_STEEL_FIREBOX_CASING.get()))
                    .where('V', Predicates.blocks(GTBlocks.CASING_LAMINATED_GLASS.get()))
                    .where('B', Predicates.blocks(EvoBlocks.SOLID_STAINLESS_STEEL_MACHINE_CASING.get()))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"), EvolutionCoreMod.id("block/machines/ore_processing_factory"))
            .langValue("Ore Processing Factory")
            .tooltips(Component.translatable("evolutioncore.tooltip.ore_processing_factory").withStyle(ChatFormatting.GRAY))
            .register();

    public static final MultiblockMachineDefinition ORE_PROCESSING_PLANT = Reference.REGISTRATE
            .multiblock("ore_processing_plant", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GTBlocks.CASING_TUNGSTENSTEEL_ROBUST)
            .recipeType(EvoRecipeTypes.ORE_PROCESSING_PLANT)
            .recipeModifiers(GTRecipeModifiers.PARALLEL_HATCH, GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK))
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice("  FFF  ", "  CCC  ", "  CVC  ", "  CVC  ", "  CVC  ", "  CCC  ", "       ", "       ", "       ", "       ")
                    .slice(" FCCCF ", " CGGGC ", " V###V ", " V###V ", " C###C ", " C###C ", " CCVCC ", "  CCC  ", "       ", "       ")
                    .slice("FCCCCCF", "CG###GC", "C#####C", "C#####C", "C#####C", "C#####C", " C###C ", " C###C ", "  CCC  ", "  BBB  ")
                    .slice("FCCCCCF", "CG#P#GC", "V##P##V", "V##P##V", "V##P##V", "C##P##C", " V#P#V ", " C#P#C ", "  CMC  ", "  B B  ")
                    .slice("FCCCCCF", "CG###GC", "C#####C", "C#####C", "C#####C", "C#####C", " C###C ", " C###C ", "  CCC  ", "  BBB  ")
                    .slice(" FCCCF ", " CGGGC ", " V###V ", " V###V ", " C###C ", " C###C ", " CCVCC ", "  CCC  ", "       ", "       ")
                    .slice("  FFF  ", "  C@C  ", "  CVC  ", "  CVC  ", "  CVC  ", "  CCC  ", "       ", "       ", "       ", "       ")
                    .where('@', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('#', Predicates.air())
                    .where('C', Predicates.blocks(GTBlocks.CASING_TUNGSTENSTEEL_ROBUST.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.PARALLEL_HATCH).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1).setMaxGlobalLimited(6).setPreviewCount(6))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setExactLimit(1)))
                    .where('M', Predicates.abilities(PartAbility.MUFFLER))
                    .where('P', Predicates.blocks(GTBlocks.CASING_TUNGSTENSTEEL_PIPE.get()))
                    .where('G', Predicates.blocks(GTBlocks.CASING_TUNGSTENSTEEL_GEARBOX.get()))
                    .where('F', Predicates.blocks(GTBlocks.FIREBOX_TUNGSTENSTEEL.get()))
                    .where('V', Predicates.blocks(GTBlocks.CASING_LAMINATED_GLASS.get()))
                    .where('B', Predicates.blocks(EvoBlocks.SOLID_TUNGSTENSTEEL_MACHINE_CASING.get()))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_robust_tungstensteel"), EvolutionCoreMod.id("block/machines/ore_processing_factory"))
            .langValue("Ore Processing Plant")
            .tooltips(Component.translatable("evolutioncore.tooltip.ore_processing_plant").withStyle(ChatFormatting.GRAY))
            .register();

    public static final MultiblockMachineDefinition BULK_ORE_PROCESSING_PLANT = Reference.REGISTRATE
            .multiblock("bulk_ore_processing_plant", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(EvoBlocks.NAQUADAH_ALLOY_MACHINE_CASING)
            .recipeType(EvoRecipeTypes.BULK_ORE_PROCESSING_PLANT)
            .recipeModifiers(GTRecipeModifiers.PARALLEL_HATCH, GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK))
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice("  FFF  ", "  CCC  ", "  CVC  ", "  CVC  ", "  CVC  ", "  CCC  ", "       ", "       ", "       ", "       ")
                    .slice(" FCCCF ", " CGGGC ", " V###V ", " V###V ", " C###C ", " C###C ", " CCVCC ", "  CCC  ", "       ", "       ")
                    .slice("FCCCCCF", "CG###GC", "C#####C", "C#####C", "C#####C", "C#####C", " C###C ", " C###C ", "  CCC  ", "  BBB  ")
                    .slice("FCCCCCF", "CG#P#GC", "V##P##V", "V##P##V", "V##P##V", "C##P##C", " V#P#V ", " C#P#C ", "  CMC  ", "  B B  ")
                    .slice("FCCCCCF", "CG###GC", "C#####C", "C#####C", "C#####C", "C#####C", " C###C ", " C###C ", "  CCC  ", "  BBB  ")
                    .slice(" FCCCF ", " CGGGC ", " V###V ", " V###V ", " C###C ", " C###C ", " CCVCC ", "  CCC  ", "       ", "       ")
                    .slice("  FFF  ", "  C@C  ", "  CVC  ", "  CVC  ", "  CVC  ", "  CCC  ", "       ", "       ", "       ", "       ")
                    .where('@', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('#', Predicates.air())
                    .where('C', Predicates.blocks(EvoBlocks.NAQUADAH_ALLOY_MACHINE_CASING.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.PARALLEL_HATCH).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setMinGlobalLimited(1).setMaxGlobalLimited(6).setPreviewCount(6))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setExactLimit(1)))
                    .where('M', Predicates.abilities(PartAbility.MUFFLER))
                    .where('P', Predicates.blocks(EvoBlocks.NAQUADAH_ALLOY_PIPE_CASING.get()))
                    .where('G', Predicates.blocks(EvoBlocks.NAQUADAH_ALLOY_GEARBOX_CASING.get()))
                    .where('F', Predicates.blocks(EvoBlocks.NAQUADAH_ALLOY_FIREBOX_CASING.get()))
                    .where('V', Predicates.blocks(GTBlocks.FUSION_GLASS.get()))
                    .where('B', Predicates.blocks(EvoBlocks.SOLID_NAQUADAH_ALLOY_MACHINE_CASING.get()))
                    .where(' ', Predicates.any())
                    .build())
            .workableCasingModel(EvolutionCoreMod.id("block/casings/naquadah_alloy/casing"), EvolutionCoreMod.id("block/machines/ore_processing_factory"))
            .langValue("Bulk Ore Processing Plant")
            .tooltips(Component.translatable("evolutioncore.tooltip.bulk_ore_processing_plant").withStyle(ChatFormatting.GRAY))
            .register();
}
