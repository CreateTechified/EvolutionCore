package io.github.createtechified.evolutioncore.common.registry.machines;

import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.machine.steam.SimpleSteamMachine;
import com.gregtechceu.gtceu.api.pattern.util.RelativeDirection;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.machines.steam.SteamVacuumPump;
import io.github.createtechified.evolutioncore.common.registry.machines.utils.MachineUtils;
import io.github.createtechified.evolutioncore.common.registry.recipes.ModRecipeTypes;
import it.unimi.dsi.fastutil.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class GTSteamSingleblocks {
    public static void init() {}

    public static final Pair<MachineDefinition, MachineDefinition> STEAM_VACUUM_PUMP = GTMachineUtils.registerSteamMachines(Reference.REGISTRATE, "steam_vacuum_pump",
            SteamVacuumPump::new, (pressure, builder) -> builder
                    .rotationState(RotationState.ALL)
                    .recipeType(ModRecipeTypes.VACUUM_PUMP_RECIPES)
                    .recipeModifier(SimpleSteamMachine::recipeModifier)
                    .modelProperty(GTMachineModelProperties.VENT_DIRECTION, RelativeDirection.BACK)
                    .workableSteamHullModel(pressure, EvolutionCoreMod.id("block/machines/vacuum_pump"))
                    .tooltips(Component.translatable("evolutioncore.tooltip.vacuum_pump", pressure ? 2 : 1).withStyle(ChatFormatting.GRAY))
                    .register());

    public static final Pair<MachineDefinition, MachineDefinition> STEAM_ASSEMBLER = MachineUtils
            .registerSimpleSteamMachines("assembler", GTRecipeTypes.ASSEMBLER_RECIPES, Component.translatable("evolutioncore.tooltip.steam_assembler").withStyle(ChatFormatting.GRAY));
}
