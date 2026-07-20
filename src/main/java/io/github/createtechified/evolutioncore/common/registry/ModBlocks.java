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
    public static BlockEntry<Block> ORGANIC_PLANT_MATTER = EvoConstructs.constructBasicBlock("organic_plant_matter", "Organic Plant Matter");
    public static BlockEntry<Block> STAINLESS_STEEL_HULL = EvoConstructs.constructBasicBlock("stainless_steel_machine_casing", "Stainless Steel Machine Casing");
    public static BlockEntry<Block> STAINLESS_STEEL_PIPE_CASING = EvoConstructs.constructBasicBlock("stainless_steel_pipe_casing", "Stainless Steel Pipe Casing");
    public static BlockEntry<ActiveBlock> STAINLESS_STEEL_FIREBOX_CASING = EvoConstructs.constructFirebox(new EvoConstructs.FireboxInfo("stainless_steel_firebox",
            GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
            GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
            EvolutionCoreMod.id("block/stainless_steel_firebox_casing")), "Stainless Steel Firebox Casing");
    public static BlockEntry<Block> TUNGSTENSTEEL_HULL = EvoConstructs.constructBasicBlock("tungstensteel_machine_casing", "Tungstensteel Machine Casing");
    public static BlockEntry<Block> NAQUADAH_ALLOY_CASING = EvoConstructs.constructBasicBlock("naquadah_alloy_machine_casing", "Naquadah Alloy Casing");
    public static BlockEntry<Block> NAQUADAH_ALLOY_PIPE_CASING = EvoConstructs.constructBasicBlock("naquadah_alloy_pipe_casing",  "Naquadah Alloy Pipe Casing");
    public static BlockEntry<Block> NAQUADAH_ALLOY_GEARBOX_CASING = EvoConstructs.constructBasicBlock("naquadah_alloy_gearbox_casing", "Naquadah Alloy Gearbox Casing");
    public static BlockEntry<Block> NAQUADAH_ALLOY_TURBINE_CASING = EvoConstructs.constructBasicBlock("naquadah_alloy_turbine_casing", "Naquadah Alloy Turbine Casing");
    public static BlockEntry<Block> NAQUADAH_ALLOY_HULL = EvoConstructs.constructBasicBlock("solid_naquadah_alloy_machine_casing", "Naquadah Alloy Machine Casing" );
    public static BlockEntry<ActiveBlock> NAQUADAH_ALLOY_FIREBOX_CASING = EvoConstructs.constructFirebox(new EvoConstructs.FireboxInfo("naquadah_alloy_firebox",
            EvolutionCoreMod.id("block/naquadah_alloy_machine_casing"),
            EvolutionCoreMod.id("block/naquadah_alloy_machine_casing"),
            EvolutionCoreMod.id("block/naquadah_alloy_firebox_casing")), "Naquadah Alloy Firebox Casing");
    public static BlockEntry<ActiveBlock> CASING_LUDICROUS_ENGINE_INTAKE = EvoConstructs.constructBlock("ludicrous_engine_intake_casing", ActiveBlock::new);
}
