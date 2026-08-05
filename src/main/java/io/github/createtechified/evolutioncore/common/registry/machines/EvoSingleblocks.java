package io.github.createtechified.evolutioncore.common.registry.machines;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.EvoTabs;
import io.github.createtechified.evolutioncore.common.registry.utils.MachineConstructors;
import it.unimi.dsi.fastutil.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

@SuppressWarnings("unused")
public class EvoSingleblocks {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MACHINES);
    }

    public static final Pair<MachineDefinition, MachineDefinition> STEAM_ASSEMBLER = MachineConstructors
            .registerSimpleSteamMachines("assembler", GTRecipeTypes.ASSEMBLER_RECIPES, Component.translatable("evolutioncore.tooltip.steam_assembler").withStyle(ChatFormatting.GRAY));
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_CENTRIFUGE = MachineConstructors
            .registerSimpleSteamMachines("centrifuge", GTRecipeTypes.CENTRIFUGE_RECIPES, Component.translatable("evolutioncore.tooltip.steam_centrifuge").withStyle(ChatFormatting.GRAY));
    public static final Pair<MachineDefinition, MachineDefinition> STEAM_ORE_WASHER = MachineConstructors
            .registerSimpleSteamMachines("ore_washer", GTRecipeTypes.ORE_WASHER_RECIPES, Component.translatable("evolutioncore.tooltip.steam_ore_washer").withStyle(ChatFormatting.GRAY));
}
