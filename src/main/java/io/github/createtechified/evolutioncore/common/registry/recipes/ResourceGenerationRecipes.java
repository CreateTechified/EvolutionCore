package io.github.createtechified.evolutioncore.common.registry.recipes;

import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.utils.RecipeConstructors;
import net.minecraft.data.recipes.RecipeOutput;

public class ResourceGenerationRecipes {
    public static void init(Consumer<FinishedRecipe> c) {
        // Greenhouse
        RecipeConstructors.greenhouseWoodRecipes(c,"minecraft", "oak", null);
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "spruce", null);
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "birch", null);
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "acacia", null);
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "dark_oak", null);
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "jungle", null);
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "cherry", null);
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "_propagule", "mangrove", "_log", "mangrove_roots");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "_fungus", "crimson", "_stem", "nether_wart");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "_fungus", "warped", "_stem", null);
        RecipeConstructors.greenhouseWoodRecipes(c, "gtceu", "rubber", "sticky_resin");
        if (Reference.ML_IntegratedDynamics) {
            RecipeConstructors.greenhouseWoodRecipes(c, "integrateddynamics", "menril", "crystalized_menril_chunk");
        }
        if (Reference.ML_BiomesWeveGone) {
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "aspen", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "baobab", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "blue_enchanted", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "cika", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "cypress", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "ebony", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "fir", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "green_enchanted", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "holly", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "ironwood", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "jacaranda", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "mahogany", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "maple", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "palm", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "pine", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "rainbow_eucalyptus", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "redwood", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "skyris", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "white_mangrove", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "willow", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "witch_hazel", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "zelkova", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "palo_verde", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "_sapling", "sakura", "_log", "white_", null);
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "_sapling", "sakura", "_log", "yellow_", null);
        }
        if (Reference.ML_Occultism) {
            RecipeConstructors.greenhouseWoodRecipes(c, "occultism", "otherworld", null);
        }

        // Nuclear
        RecipeConstructors.fuelRodRecipes(c, "gtceu", "thorium", "evolutioncore", "thorium");
        RecipeConstructors.fuelRodRecipes(c, "gtceu", "uranium", "evolutioncore", "uranium_238");
        RecipeConstructors.fuelRodRecipes(c, "gtceu", "uranium_235", "evolutioncore", "uranium_235");
        RecipeConstructors.fuelRodRecipes(c, "gtceu", "plutonium", "evolutioncore", "plutonium");
        RecipeConstructors.depletedFuelRodRecipes(c, "evolutioncore", "thorium", "gtceu", "uranium_235", "gtceu", "rare_earth", "gtceu", "tritium");
        RecipeConstructors.depletedFuelRodRecipes(c, "evolutioncore", "uranium_238", "gtceu", "plutonium", "gtceu", "thorium");
        RecipeConstructors.depletedFuelRodRecipes(c, "evolutioncore", "uranium_235", "gtceu", "plutonium_241", "gtceu", "caesium", "gtceu", "krypton", "gtceu", "xenon");
        RecipeConstructors.depletedFuelRodRecipes(c, "evolutioncore", "plutonium", "gtceu", "polonium", "gtceu", "technetium");
        RecipeConstructors.simpleFissionReactions(c, "evolutioncore", "thorium", "evolutioncore", "thorium", -2048);
        RecipeConstructors.simpleFissionReactions(c, "evolutioncore", "uranium_238", "evolutioncore", "uranium_238", -4096);
        RecipeConstructors.simpleFissionReactions(c, "evolutioncore", "uranium_235", "evolutioncore", "uranium_235",  -8192);
        RecipeConstructors.simpleFissionReactions(c, "evolutioncore", "plutonium", "evolutioncore", "plutonium", -16384);
    }
}