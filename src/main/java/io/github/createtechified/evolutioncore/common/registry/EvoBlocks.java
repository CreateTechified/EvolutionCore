package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.utils.ActiveBlockConstructors;
import io.github.createtechified.evolutioncore.common.registry.utils.BlockConstructors;
import net.minecraft.world.level.block.Block;

public class EvoBlocks {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MAIN);
    }

    public static BlockEntry<Block> HP_STEAM_MACHINE_CASING = BlockConstructors.constructCasingBlock("hp_steam_machine_casing", "steam", "High Pressure Steam Machine Casing");
    public static BlockEntry<ActiveBlock> HP_STEAM_FIREBOX_CASING = ActiveBlockConstructors.constructFirebox(new ActiveBlockConstructors.FireboxInfo("hp_steam_firebox_casing",
            EvolutionCoreMod.id("block/casings/steam/hp_steam_machine_casing"),
            EvolutionCoreMod.id("block/casings/steam/hp_steam_machine_casing"),
            GTCEu.id("block/casings/firebox/machine_casing_firebox_steel")), "High Pressure Steam Firebox Casing");
}
