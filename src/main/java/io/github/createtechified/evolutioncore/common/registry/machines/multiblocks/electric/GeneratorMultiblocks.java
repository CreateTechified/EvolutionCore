package io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.electric;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.multiblock.Predicates;
import com.gregtechceu.gtceu.api.multiblock.pattern.MultiblockPatternBuilder;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.common.data.GCYMBlocks;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.EvoBlocks;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

import static com.gregtechceu.gtceu.api.GTValues.ZPM;
import static com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection.*;
import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.registerLargeCombustionEngine;

public class GeneratorMultiblocks {
    public static void init() {}

    public static final MultiblockMachineDefinition LUDICROUS_COMBUSTION_ENGINE = registerLargeCombustionEngine(
            Reference.REGISTRATE, "ludicrous_combustion_engine", ZPM,
            EvoBlocks.NAQUADAH_ALLOY_MACHINE_CASING, EvoBlocks.NAQUADAH_ALLOY_GEARBOX_CASING, EvoBlocks.LUDICROUS_ENGINE_INTAKE_CASING,
            EvolutionCoreMod.id("block/casings/naquadah_alloy/casing"),
            GTCEu.id("block/multiblock/generator/extreme_combustion_engine"));

    public static final MultiblockMachineDefinition SIMPLE_FISSION_REACTOR = Reference.REGISTRATE
            .multiblock("simple_fission_reactor", WorkableElectricMultiblockMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(GCYMBlocks.CASING_HIGH_TEMPERATURE_SMELTING)
            .recipeType(EvoRecipeTypes.FISSION_REACTOR_FUELS)
            .recipeModifiers(GTRecipeModifiers.ELECTRIC_OVERCLOCK.apply(OverclockingLogic.PERFECT_OVERCLOCK))
            .generator(true)
            .pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                    .slice(" VCV ", " CCC ", " CGC ", " CGC ", " CGC ", " CCC ", " VCV ")
                    .slice("VCCCV", "CMMMC", "CH#HC", "CH#HC", "CH#HC", "CMMMC", "VCCCV")
                    .slice("CCCCC", "CMMMC", "G#W#G", "G#W#G", "G#W#G", "CMMMC", "CCCCC")
                    .slice("VCCCV", "CMMMC", "CH#HC", "CH#HC", "CH#HC", "CMMMC", "VCCCV")
                    .slice(" VCV ", " C@C ", " CGC ", " CGC ", " CGC ", " CCC ", " VCV ")
                    .where('@', Predicates.controller(definition))
                    .where('#', Predicates.air())
                    .where('V', Predicates.blocks(GCYMBlocks.HEAT_VENT.get()))
                    .where('C', Predicates.blocks(GCYMBlocks.CASING_HIGH_TEMPERATURE_SMELTING.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.PARALLEL_HATCH).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS).setMaxGlobalLimited(1))
                            .or(Predicates.abilities(PartAbility.OUTPUT_ENERGY).setExactLimit(1)))
                    .where('G', Predicates.blocks(GTBlocks.CASING_LAMINATED_GLASS.get()))
                    .where('H', Predicates.blocks(GTBlocks.COIL_RTMALLOY.get()))
                    .where('M', Predicates.blocks(GCYMBlocks.CASING_HIGH_TEMPERATURE_SMELTING.get()))
                    .where(' ', Predicates.any())
                    .where('W', Predicates.blocks(Objects.requireNonNull(ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("create", "cut_deepslate_wall")))))
                    .build()) // ^ We force Create, so this should be fine. If anything breaks it's your fault.
            .workableCasingModel(GTCEu.id("block/casings/gcym/high_temperature_smelting_casing"), EvolutionCoreMod.id("block/machines/simple_fission_reactor"))
            .langValue("Simple Fission Reactor")
            .tooltips(Component.translatable("evolutioncore.tooltip.simple_fission_reactor").withStyle(ChatFormatting.GRAY))
            .register();
}
