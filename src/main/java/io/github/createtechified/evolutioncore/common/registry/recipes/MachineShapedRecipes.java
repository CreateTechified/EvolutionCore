package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.common.registry.EvoBlocks;
import io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.SteamMultiblocksHP;
import io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.SteamMultiblocksLP;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class MachineShapedRecipes {
    public static void init(Consumer<FinishedRecipe> c) {
        //TODO: make better recipes, these "work" but need to be more fitting (and challenging)

        // Singleblocks

        // Multiblocks
        VanillaRecipeHelper.addShapelessRecipe(c, EvolutionCoreMod.id("lp_steam_oven_swap"), SteamMultiblocksLP.LP_STEAM_OVEN.asStack(), GTMultiMachines.STEAM_OVEN.asStack());
        VanillaRecipeHelper.addShapelessRecipe(c, EvolutionCoreMod.id("lp_steam_grinder_swap"), SteamMultiblocksLP.LP_STEAM_GRINDER.asStack(), GTMultiMachines.STEAM_GRINDER.asStack());
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
    }
}
