package io.github.createtechified.evolutioncore.common.registry.machines;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.machine.steam.SteamMufflerPartMachine;

public class GTMultiblockParts {
    public static void init() {}

    public static final PartAbility STEAM_VENT = new PartAbility("steam_vent");

    public static final MachineDefinition STEAM_VENTING_HATCH = Reference.REGISTRATE
            .machine("steam_venting_hatch", SteamMufflerPartMachine::new)
            .rotationState(RotationState.ALL)
            .abilities(STEAM_VENT)
            .modelProperty(GTMachineModelProperties.IS_FORMED, false)
            .colorOverlaySteamHullModel(GTCEu.id("block/overlay/machine/overlay_steam_vent"))
            .langValue("Steam Venting Hatch")
            .register();
}
