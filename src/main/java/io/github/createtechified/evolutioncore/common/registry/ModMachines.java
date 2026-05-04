package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.steam.SimpleSteamMachine;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import io.github.createtechified.evolutioncore.common.machines.steam.SteamVacuumPump;
import it.unimi.dsi.fastutil.Pair;
import net.minecraft.network.chat.Component;

public class ModMachines {
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_VACUUM_PUMP = GTMachineUtils.registerSteamMachines(GTEvoRegistry.REGISTRATE, "steam_vacuum_pump",
            SteamVacuumPump::new, (pressure, builder) -> builder.rotationState(RotationState.ALL)
                    .recipeType(ModRecipeTypes.VACUUM_PUMP_RECIPES)
                    .recipeModifier(SimpleSteamMachine::recipeModifier)
                    .tooltips(Component.translatable("gtocore.recipe.vacuum.tier", pressure ? 2 : 1))
                    .register());
}
