package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.common.registry.EvoBlocks;
import io.github.createtechified.evolutioncore.common.registry.machines.EvoSingleblocks;
import io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.PrimitiveMultiblocks;
import io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.SteamMultiblocksHP;
import io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.SteamMultiblocksLP;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class MachineShapedRecipes {
    public static void init(Consumer<FinishedRecipe> c) {
        //TODO: make better recipes, these "work" but need to be more fitting (and challenging)

        // Singleblocks

        // Multiblocks
        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("lp_steam_oven"),
                SteamMultiblocksLP.LP_STEAM_OVEN.asStack(),
                "CGC", "FMF", "CGC",
                'F', GTBlocks.FIREBOX_BRONZE.asStack(),
                'C', GTBlocks.CASING_BRONZE_BRICKS.asStack(),
                'M', GTMachines.STEAM_FURNACE.left().asStack(),
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Invar));

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("hp_steam_oven"),
                SteamMultiblocksHP.HP_STEAM_OVEN.asStack(),
                "CGC", "FMF", "CGC",
                'F', EvoBlocks.HP_STEAM_FIREBOX_CASING.asStack(),
                'C', EvoBlocks.HP_STEAM_MACHINE_CASING.asStack(),
                'M', SteamMultiblocksLP.LP_STEAM_OVEN.asStack(),
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Invar));

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("lp_steam_grinder"),
                SteamMultiblocksLP.LP_STEAM_GRINDER.asStack(),
                "CGC", "CFC", "CGC",
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Potin),
                'F', GTMachines.STEAM_MACERATOR.left().asStack(),
                'C', GTBlocks.CASING_BRONZE_BRICKS.asStack());

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("hp_steam_grinder"),
                SteamMultiblocksHP.HP_STEAM_GRINDER.asStack(),
                "CGC", "CFC", "CGC",
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Potin),
                'F', SteamMultiblocksLP.LP_STEAM_GRINDER.asStack(),
                'C', EvoBlocks.HP_STEAM_MACHINE_CASING.asStack());

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("lp_steam_alloy_kiln"),
                SteamMultiblocksLP.LP_STEAM_ALLOY_KILN.asStack(),
                "CGC", "CFC", "CGC",
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Potin),
                'F', GTMachines.STEAM_ALLOY_SMELTER.left().asStack(),
                'C', GTBlocks.CASING_BRONZE_BRICKS.asStack());

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("hp_steam_alloy_kiln"),
                SteamMultiblocksHP.HP_STEAM_ALLOY_KILN.asStack(),
                "CGC", "CFC", "CGC",
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Potin),
                'F', SteamMultiblocksLP.LP_STEAM_ALLOY_KILN.asStack(),
                'C', EvoBlocks.HP_STEAM_MACHINE_CASING.asStack());

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("lp_steam_impact_forge"),
                SteamMultiblocksLP.LP_STEAM_IMPACT_FORGE.asStack(),
                "CGC", "CFC", "CGC",
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Potin),
                'F', GTMachines.STEAM_HAMMER.left().asStack(),
                'C', GTBlocks.CASING_BRONZE_BRICKS.asStack());

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("hp_steam_impact_forge"),
                SteamMultiblocksHP.HP_STEAM_IMPACT_FORGE.asStack(),
                "CGC", "CFC", "CGC",
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Potin),
                'F', SteamMultiblocksLP.LP_STEAM_IMPACT_FORGE.asStack(),
                'C', EvoBlocks.HP_STEAM_MACHINE_CASING.asStack());

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("lp_steam_seperator"),
                SteamMultiblocksLP.LP_STEAM_SEPARATOR.asStack(),
                "CGC", "CFC", "CGC",
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Potin),
                'F', EvoSingleblocks.STEAM_CENTRIFUGE.left().asStack(),
                'C', GTBlocks.CASING_BRONZE_BRICKS.asStack());

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("hp_steam_seperator"),
                SteamMultiblocksHP.HP_STEAM_SEPARATOR.asStack(),
                "CGC", "CFC", "CGC",
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Potin),
                'F', SteamMultiblocksLP.LP_STEAM_SEPARATOR.asStack(),
                'C', EvoBlocks.HP_STEAM_MACHINE_CASING.asStack());

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("lp_steam_purifier"),
                SteamMultiblocksLP.LP_STEAM_PURIFIER.asStack(),
                "CGC", "CFC", "CGC",
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Potin),
                'F', EvoSingleblocks.STEAM_ORE_WASHER.left().asStack(),
                'C', GTBlocks.CASING_BRONZE_BRICKS.asStack());

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("hp_steam_purifier"),
                SteamMultiblocksHP.HP_STEAM_PURIFIER.asStack(),
                "CGC", "CFC", "CGC",
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Potin),
                'F', SteamMultiblocksLP.LP_STEAM_PURIFIER.asStack(),
                'C', EvoBlocks.HP_STEAM_MACHINE_CASING.asStack());

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("lp_steam_ore_factory"),
                SteamMultiblocksLP.LP_STEAM_ORE_FACTORY.asStack(),
                "CGC", "CFC", "CGC",
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Potin),
                'F', PrimitiveMultiblocks.PRIMITIVE_ORE_FACTORY.asStack(),
                'C', GTBlocks.CASING_BRONZE_BRICKS.asStack());

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("hp_steam_ore_factory"),
                SteamMultiblocksHP.HP_STEAM_ORE_FACTORY.asStack(),
                "CGC", "CFC", "CGC",
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.Potin),
                'F', SteamMultiblocksLP.LP_STEAM_ORE_FACTORY.asStack(),
                'C', EvoBlocks.HP_STEAM_MACHINE_CASING.asStack());

        // Stainless Steel Casings
        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("stainless_steel_pipe_casing"),
                EvoBlocks.STAINLESS_STEEL_PIPE_CASING.asStack(2),
                "PNP", "NFN", "PNP",
                'P', new MaterialEntry(TagPrefix.plate, GTMaterials.StainlessSteel),
                'F', new MaterialEntry(TagPrefix.frameGt, GTMaterials.StainlessSteel),
                'N', new MaterialEntry(TagPrefix.pipeNormalFluid, GTMaterials.StainlessSteel));

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("stainless_steel_firebox_casing"),
                EvoBlocks.STAINLESS_STEEL_FIREBOX_CASING.asStack(2),
                "PRP", "RFR", "PRP",
                'P', new MaterialEntry(TagPrefix.plate, GTMaterials.StainlessSteel),
                'F', new MaterialEntry(TagPrefix.frameGt, GTMaterials.StainlessSteel),
                'R', new MaterialEntry(TagPrefix.rod, GTMaterials.StainlessSteel));

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("stainless_steel_machine_casing"),
                EvoBlocks.SOLID_STAINLESS_STEEL_MACHINE_CASING.asStack(),
                "PPP", "PHP", "PPP",
                'P', new MaterialEntry(TagPrefix.plate, GTMaterials.StainlessSteel),
                'H', CustomTags.CRAFTING_HAMMERS);

        // Tungstensteel Casings
        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("tungstensteel_machine_casing"),
                EvoBlocks.SOLID_TUNGSTENSTEEL_MACHINE_CASING.asStack(),
                "PPP", "PHP", "PPP",
                'P', new MaterialEntry(TagPrefix.plate, GTMaterials.TungstenSteel),
                'H', CustomTags.CRAFTING_HAMMERS);

        // Naquadah Casings
        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("naquadah_alloy_machine_casing"),
                EvoBlocks.NAQUADAH_ALLOY_MACHINE_CASING.asStack(2),
                "PHP", "PFP", "PWP",
                'P', new MaterialEntry(TagPrefix.plate, GTMaterials.NaquadahAlloy),
                'H', CustomTags.CRAFTING_HAMMERS,
                'F', new MaterialEntry(TagPrefix.frameGt, GTMaterials.NaquadahAlloy),
                'W', CustomTags.CRAFTING_WRENCHES);

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("naquadah_alloy_gearbox"),
                EvoBlocks.NAQUADAH_ALLOY_GEARBOX_CASING.asStack(2),
                "PHP", "GFG", "PWP",
                'P', new MaterialEntry(TagPrefix.plate, GTMaterials.NaquadahAlloy),
                'H', CustomTags.CRAFTING_HAMMERS,
                'F', new MaterialEntry(TagPrefix.frameGt, GTMaterials.NaquadahAlloy),
                'W', CustomTags.CRAFTING_WRENCHES,
                'G', new MaterialEntry(TagPrefix.gear, GTMaterials.NaquadahAlloy));

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("naquadah_alloy_pipe_casing"),
                EvoBlocks.NAQUADAH_ALLOY_PIPE_CASING.asStack(2),
                "PNP", "NFN", "PNP",
                'P', new MaterialEntry(TagPrefix.plate, GTMaterials.NaquadahAlloy),
                'F', new MaterialEntry(TagPrefix.frameGt, GTMaterials.NaquadahAlloy),
                'N', new MaterialEntry(TagPrefix.pipeNormalFluid, GTMaterials.NaquadahAlloy));

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("naquadah_alloy_firebox_casing"),
                EvoBlocks.NAQUADAH_ALLOY_FIREBOX_CASING.asStack(2),
                "PRP", "RFR", "PRP",
                'P', new MaterialEntry(TagPrefix.plate, GTMaterials.NaquadahAlloy),
                'F', new MaterialEntry(TagPrefix.frameGt, GTMaterials.NaquadahAlloy),
                'R', new MaterialEntry(TagPrefix.rod, GTMaterials.NaquadahAlloy));

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("ludicrous_engine_intake_casing"),
                EvoBlocks.LUDICROUS_ENGINE_INTAKE_CASING.asStack(2),
                "NHN", "RCR", "NWN",
                'N', new MaterialEntry(TagPrefix.pipeNormalFluid, GTMaterials.NaquadahAlloy),
                'H', CustomTags.CRAFTING_HAMMERS,
                'C', EvoBlocks.NAQUADAH_ALLOY_MACHINE_CASING.asStack(),
                'W', CustomTags.CRAFTING_WRENCHES,
                'R', new MaterialEntry(TagPrefix.rotor, GTMaterials.NaquadahAlloy));

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("naquadah_alloy_turbine_casing"),
                EvoBlocks.NAQUADAH_ALLOY_TURBINE_CASING.asStack(2),
                "PHP", "PCP", "PWP",
                'P', new MaterialEntry(TagPrefix.plate, GTMaterials.NaquadahAlloy),
                'H', CustomTags.CRAFTING_HAMMERS,
                'C', GTBlocks.CASING_STEEL_TURBINE.asStack(),
                'W', CustomTags.CRAFTING_WRENCHES);

        VanillaRecipeHelper.addShapedRecipe(c, true, EvolutionCoreMod.id("solid_naquadah_alloy_machine_casing"),
                EvoBlocks.SOLID_NAQUADAH_ALLOY_MACHINE_CASING.asStack(),
                "PPP", "PHP", "PPP",
                'P', new MaterialEntry(TagPrefix.plate, GTMaterials.NaquadahAlloy),
                'H', CustomTags.CRAFTING_HAMMERS);
    }
}