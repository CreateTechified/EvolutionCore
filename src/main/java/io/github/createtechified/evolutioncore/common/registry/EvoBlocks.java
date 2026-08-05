package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.utils.ActiveBlockConstructors;
import io.github.createtechified.evolutioncore.common.registry.utils.BlockConstructors;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

@SuppressWarnings("unused")
public class EvoBlocks {
    public static void init() {}

    public static BlockEntry<Block> HP_STEAM_MACHINE_CASING = BlockConstructors.constructSteamCasingBlock("hp_steam_machine_casing", "High Pressure Steam Machine Casing");
    public static BlockEntry<ActiveBlock> HP_STEAM_FIREBOX_CASING = ActiveBlockConstructors.constructFirebox(new ActiveBlockConstructors.FireboxInfo("hp_steam_firebox_casing",
            EvolutionCoreMod.id("block/casings/steam/hp_steam_machine_casing"),
            EvolutionCoreMod.id("block/casings/steam/hp_steam_machine_casing"),
            GTCEu.id("block/casings/firebox/machine_casing_firebox_steel")), "High Pressure Steam Firebox Casing");
    public static BlockEntry<Block> ORGANIC_PLANT_MATTER = BlockConstructors.constructBasicBlock("organic_plant_matter", EvolutionCoreMod.id("block/general/organic_plant_matter"), "Organic Plant Matter", Blocks.DIRT);
    public static BlockEntry<Block> SOLID_STAINLESS_STEEL_MACHINE_CASING = BlockConstructors.constructSolidCasingBlock("solid_stainless_steel_machine_casing", "stainless_steel", "Solid Stainless Steel Machine Casing");
    public static BlockEntry<Block> STAINLESS_STEEL_PIPE_CASING = BlockConstructors.constructPipeCasingBlock("stainless_steel_pipe_casing", "stainless_steel", "Stainless Steel Pipe Casing");
    public static BlockEntry<ActiveBlock> STAINLESS_STEEL_FIREBOX_CASING = ActiveBlockConstructors.constructFirebox(new ActiveBlockConstructors.FireboxInfo("stainless_steel_firebox",
            GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
            GTCEu.id("block/casings/solid/machine_casing_clean_stainless_steel"),
            EvolutionCoreMod.id("block/casings/stainless_steel/firebox")), "Stainless Steel Firebox Casing");
    public static BlockEntry<Block> SOLID_TUNGSTENSTEEL_MACHINE_CASING = BlockConstructors.constructSolidCasingBlock("solid_tungstensteel_machine_casing", "tungstensteel", "Tungstensteel Machine Casing");
    public static BlockEntry<Block> NAQUADAH_ALLOY_MACHINE_CASING = BlockConstructors.constructCasingBlock("naquadah_alloy_machine_casing", "naquadah_alloy", "Naquadah Alloy Machine Casing");
    public static BlockEntry<Block> NAQUADAH_ALLOY_PIPE_CASING = BlockConstructors.constructPipeCasingBlock("naquadah_alloy_pipe_casing", "naquadah_alloy", "Naquadah Alloy Pipe Casing");
    public static BlockEntry<Block> NAQUADAH_ALLOY_GEARBOX_CASING = BlockConstructors.constructGearboxCasingBlock("naquadah_alloy_gearbox_casing", "naquadah_alloy", "Naquadah Alloy Gearbox Casing");
    public static BlockEntry<Block> NAQUADAH_ALLOY_TURBINE_CASING = BlockConstructors.constructTurbineCasingBlock("naquadah_alloy_turbine_casing", "naquadah_alloy", "Naquadah Alloy Turbine Casing");
    public static BlockEntry<Block> SOLID_NAQUADAH_ALLOY_MACHINE_CASING = BlockConstructors.constructSolidCasingBlock("solid_naquadah_alloy_machine_casing", "naquadah_alloy", "Solid Naquadah Alloy Machine Casing");
    public static BlockEntry<ActiveBlock> NAQUADAH_ALLOY_FIREBOX_CASING = ActiveBlockConstructors.constructFirebox(new ActiveBlockConstructors.FireboxInfo("naquadah_alloy_firebox",
            EvolutionCoreMod.id("block/casings/naquadah_alloy/casing"),
            EvolutionCoreMod.id("block/casings/naquadah_alloy/casing"),
            EvolutionCoreMod.id("block/casings/naquadah_alloy/firebox")), "Naquadah Alloy Firebox Casing");
    public static BlockEntry<ActiveBlock> LUDICROUS_ENGINE_INTAKE_CASING = ActiveBlockConstructors.constructIntakeCasingBlock("ludicrous_engine_intake_casing", "naquadah_alloy", "Ludicrous Engine Intake Casing");
}
