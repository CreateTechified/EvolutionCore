package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.tterrag.registrate.util.entry.BlockEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.utils.ActiveBlockConstructors;
import io.github.createtechified.evolutioncore.common.registry.utils.BlockConstructors;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;

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
    public static BlockEntry<Block> FUSION_CASING_MK4 = BlockConstructors.constructFusionCasingBlock("fusion_casing_mk4", "fusion_casing_mk4", "Fusion Machine Casing MK IV");
    public static BlockEntry<Block> FUSION_CASING_MK5 = BlockConstructors.constructFusionCasingBlock("fusion_casing_mk5", "fusion_casing_mk5", "Fusion Machine Casing MK V");
    public static BlockEntry<Block> INERTIAL_FUSION_CASING = BlockConstructors.constructFusionCasingBlock("inertial_fusion_casing", "inertial_fusion_casing", "Inertial Fusion Machine Casing");
    public static BlockEntry<Block> INERTIAL_FUSION_CASING_MK2 = BlockConstructors.constructFusionCasingBlock("inertial_fusion_casing_mk2", "inertial_fusion_casing_mk2", "Inertial Fusion Machine Casing MK II");

    public static final BlockEntry<StairBlock> CASING_COKE_BRICK_STAIRS = Reference.REGISTRATE
            .block("coke_oven_brick_stairs", (p) -> new StairBlock(GTBlocks.CASING_COKE_BRICKS.getDefaultState(), p))
            .initialProperties(() -> Blocks.BRICK_STAIRS)
            .lang("Coke Oven Brick Stairs")
            .tag(BlockTags.STAIRS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate((ctx, prov) -> prov.stairsBlock(ctx.getEntry(), GTCEu.id("block/casings/solid/machine_coke_bricks")))
            .item()
            .tag(ItemTags.STAIRS)
            .build()
            .register();

    public static final BlockEntry<WallBlock> CASING_COKE_BRICK_WALL = Reference.REGISTRATE
            .block("coke_oven_brick_wall", WallBlock::new)
            .initialProperties(() -> Blocks.BRICK_WALL)
            .lang("Coke Oven Brick Wall")
            .tag(BlockTags.WALLS, BlockTags.MINEABLE_WITH_PICKAXE)
            .blockstate((ctx, prov) -> prov.wallBlock(ctx.getEntry(), GTCEu.id("block/casings/solid/machine_coke_bricks")))
            .item()
            .model((ctx, prov) -> prov.wallInventory(ctx.getName(), GTCEu.id("block/casings/solid/machine_coke_bricks")))
            .tag(ItemTags.WALLS)
            .build()
            .register();
}
