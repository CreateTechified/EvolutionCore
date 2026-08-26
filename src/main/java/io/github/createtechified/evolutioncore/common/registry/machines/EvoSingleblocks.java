package io.github.createtechified.evolutioncore.common.registry.machines;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.machine.steam.SimpleSteamMachine;
import com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.mui.GTGuiTheme;
import com.gregtechceu.gtceu.common.mui.GTSingleblockMachinePanels;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import io.github.createtechified.evolutioncore.common.registry.utils.MachineConstructors;
import it.unimi.dsi.fastutil.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import static com.gregtechceu.gtceu.common.data.machines.GTMachineUtils.*;

@SuppressWarnings("unused")
public class EvoSingleblocks {
    public static void init() {}

    public static final Pair<MachineDefinition, MachineDefinition> STEAM_ASSEMBLER = MachineConstructors
            .registerSimpleSteamMachines("assembler", GTRecipeTypes.ASSEMBLER_RECIPES, Component.translatable("evolutioncore.tooltip.steam_assembler").withStyle(ChatFormatting.GRAY));
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_CENTRIFUGE = MachineConstructors
            .registerSimpleSteamMachines("centrifuge", GTRecipeTypes.CENTRIFUGE_RECIPES, Component.translatable("evolutioncore.tooltip.steam_centrifuge").withStyle(ChatFormatting.GRAY));
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_ORE_WASHER = MachineConstructors
            .registerSimpleSteamMachines("ore_washer", GTRecipeTypes.ORE_WASHER_RECIPES, Component.translatable("evolutioncore.tooltip.steam_ore_washer").withStyle(ChatFormatting.GRAY));
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_VACUUM_CHAMBER = registerSteamMachines(
            Reference.REGISTRATE, "vacuum_chamber", SimpleSteamMachine::new,
            (pressure, builder) -> builder
                    .rotationState(RotationState.ALL)
                    .recipeType(EvoRecipeTypes.VACUUM_CHAMBER_RECIPES)
                    .recipeModifier(SimpleSteamMachine::recipeModifier)
                    .themeId((i) -> i > 0 ? GTGuiTheme.STEEL.getId() : GTGuiTheme.BRONZE.getId())
                    .ui(GTSingleblockMachinePanels.GENERAL_MACHINE)
                    .modelProperty(GTMachineModelProperties.VENT_DIRECTION, RelativeDirection.BACK)
                    .workableSteamHullModel(pressure, ResourceLocation.fromNamespaceAndPath(Reference.REGISTRATE.getModid(), "block/machines/vacuum_chamber"))
                    .tooltips(Component.translatable("evolutioncore.tooltip.steam_vacuum_chamber").withStyle(ChatFormatting.GRAY))
                    .register());
    public static final MachineDefinition[] VACUUM_CHAMBER = new SimpleMachineBuilder(
            Reference.REGISTRATE, "vacuum_chamber", EvoRecipeTypes.VACUUM_CHAMBER_RECIPES)
            .tiers(GTValues.tiersBetween(GTValues.ULV, GTValues.OpV))
            .register();
}
