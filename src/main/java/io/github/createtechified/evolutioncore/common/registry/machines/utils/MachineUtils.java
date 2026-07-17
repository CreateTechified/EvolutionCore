package io.github.createtechified.evolutioncore.common.registry.machines.utils;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.api.machine.steam.SimpleSteamMachine;
import com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.gregtechceu.gtceu.common.mui.GTGuiTheme;
import com.gregtechceu.gtceu.common.mui.GTSingleblockMachinePanels;
import io.github.createtechified.evolutioncore.Reference;
import it.unimi.dsi.fastutil.Pair;
import net.minecraft.network.chat.Component;

public class MachineUtils {
    public static Pair<MachineDefinition, MachineDefinition> registerSimpleSteamMachines(String name, GTRecipeType recipeType, Component... tooltips) {
        return GTMachineUtils.registerSteamMachines(Reference.REGISTRATE, "steam_" + name, SimpleSteamMachine::new,
                (pressure, builder) -> builder
                        .rotationState(RotationState.ALL)
                        .recipeType(recipeType)
                        .recipeModifier(SimpleSteamMachine::recipeModifier)
                        .themeId((i) -> i > 0 ? GTGuiTheme.STEEL.getId() : GTGuiTheme.BRONZE.getId())
                        .ui(GTSingleblockMachinePanels.GENERAL_MACHINE)
                        .modelProperty(GTMachineModelProperties.VENT_DIRECTION, RelativeDirection.BACK)
                        .workableSteamHullModel(pressure, GTCEu.id("block/machines/" + name))
                        .tooltips(tooltips)
                        .register());
    }
}
