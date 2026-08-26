package io.github.createtechified.evolutioncore.common.registry.machines;

import brachy.modularui.utils.FormattingUtil;
import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.property.GTMachineModelProperties;
import com.gregtechceu.gtceu.common.mui.GTGuiTheme;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.data.machine.steam.SteamFluidHatchPartMachine;
import io.github.createtechified.evolutioncore.common.data.machine.steam.SteamMufflerPartMachine;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

@SuppressWarnings("unused")
public class EvoMultiParts {
    public static void init() {}

    // PartAbilities
    public static final PartAbility STEAM_VENT = new PartAbility("steam_vent");
    public static final PartAbility STEAM_IMPORT_FLUIDS = new PartAbility("steam_import_fluids");
    public static final PartAbility STEAM_EXPORT_FLUIDS = new PartAbility("steam_export_fluids");

    // Parts
    public static final MachineDefinition STEAM_VENTING_HATCH = Reference.REGISTRATE
            .machine("steam_venting_hatch", SteamMufflerPartMachine::new)
            .rotationState(RotationState.ALL)
            .abilities(STEAM_VENT)
            .modelProperty(GTMachineModelProperties.IS_FORMED, false)
            .colorOverlaySteamHullModel(GTCEu.id("block/overlay/machine/overlay_steam_vent"))
            .langValue("Steam Venting Hatch")
            .tooltips(Component.translatable("evolutioncore.tooltip.steam_vent"),
                    Component.translatable("gtceu.machine.steam_bus.tooltip"),
                    Component.translatable("evolutioncore.tooltip.steam_vent.warn").withStyle(ChatFormatting.RED))
            .allowCoverOnFront(false)
            .register();

    public static final MachineDefinition STEAM_IMPORT_HATCH = Reference.REGISTRATE
            .machine("steam_input_hatch", holder -> new SteamFluidHatchPartMachine(holder, IO.IN))
            .rotationState(RotationState.ALL)
            .abilities(STEAM_IMPORT_FLUIDS)
            .modelProperty(GTMachineModelProperties.IS_FORMED, false)
            .colorOverlaySteamHullModel(GTCEu.id("block/overlay/machine/overlay_fluid_hatch_input"), GTCEu.id("block/overlay/machine/overlay_pipe"), GTCEu.id("block/overlay/machine/overlay_pipe_in_emissive"))
            .themeId(GTGuiTheme.BRONZE.getId())
            .langValue("Steam Input Hatch")
            .tooltips(Component.translatable("gtceu.machine.fluid_hatch.import.tooltip"),
                    Component.translatable("gtceu.machine.steam_bus.tooltip"),
                    Component.translatable("gtceu.universal.tooltip.fluid_storage_capacity", FormattingUtil.formatNumbers(SteamFluidHatchPartMachine.getTankCapacity(16000, 0))))
            .allowCoverOnFront(true)
            .register();

    public static final MachineDefinition STEAM_EXPORT_HATCH = Reference.REGISTRATE
            .machine("steam_output_hatch", holder -> new SteamFluidHatchPartMachine(holder, IO.OUT))
            .rotationState(RotationState.ALL)
            .abilities(STEAM_EXPORT_FLUIDS)
            .modelProperty(GTMachineModelProperties.IS_FORMED, false)
            .colorOverlaySteamHullModel(GTCEu.id("block/overlay/machine/overlay_fluid_hatch_output"), GTCEu.id("block/overlay/machine/overlay_pipe"), GTCEu.id("block/overlay/machine/overlay_pipe_out_emissive"))
            .themeId(GTGuiTheme.BRONZE.getId())
            .langValue("Steam Output Hatch")
            .tooltips(Component.translatable("gtceu.machine.fluid_hatch.export.tooltip"),
                    Component.translatable("gtceu.machine.steam_bus.tooltip"),
                    Component.translatable("gtceu.universal.tooltip.fluid_storage_capacity", FormattingUtil.formatNumbers(SteamFluidHatchPartMachine.getTankCapacity(16000, 0))))
            .allowCoverOnFront(true)
            .register();
}