package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.utils.EvoConstructs;
import net.minecraft.world.level.block.Block;

public class ModBlocks {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> CreativeTabs.EVOLUTIONCORE_MAIN);
    }

    public static BlockEntry<Block> HIGH_STEAM_MACHINE_CASING = EvoConstructs.constructBasicBlock("high_steam_machine_casing", "High Pressure Steam Machine Casing");
    public static BlockEntry<ActiveBlock> HIGH_STEAM_FIREBOX_CASING = EvoConstructs.constructFirebox(new EvoConstructs.FireboxInfo("high_steam_firebox",
            EvolutionCoreMod.id("block/high_steam_machine_casing"),
            EvolutionCoreMod.id("block/high_steam_machine_casing"),
            GTCEu.id("block/casings/firebox/machine_casing_firebox_steel")), "High Pressure Steam Firebox Casing");
}
