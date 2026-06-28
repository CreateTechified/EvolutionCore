package io.github.createtechified.evolutioncore.common.registry.machines;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.CreativeTabs;
import io.github.createtechified.evolutioncore.common.registry.machines.utils.MachineUtils;
import it.unimi.dsi.fastutil.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public class GTSingleblocks {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> CreativeTabs.EVOLUTIONCORE_MAIN);
    }

    public static final Pair<MachineDefinition, MachineDefinition> STEAM_ASSEMBLER = MachineUtils
            .registerSimpleSteamMachines("assembler", GTRecipeTypes.ASSEMBLER_RECIPES, Component.translatable("evolutioncore.tooltip.steam_assembler").withStyle(ChatFormatting.GRAY));
}
