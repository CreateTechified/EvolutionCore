package io.github.createtechified.evolutioncore.common.registry.recipes;

import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.utils.RecipeConstructors;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class ResourceGenerationRecipes {
    public static void init(Consumer<FinishedRecipe> c) {
        // Greenhouse
        RecipeConstructors.greenhouseWoodRecipes(c,"minecraft", "oak");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "spruce");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "birch");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "acacia");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "dark_oak");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "jungle");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "cherry");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "_propagule", "mangrove", "_log", "mangrove_roots");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "_fungus", "crimson", "_stem", "nether_wart");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "_fungus", "warped", "_stem");
        RecipeConstructors.greenhouseWoodRecipes(c, "gtceu", "rubber", "sticky_resin");
        if (Reference.ML_IntegratedDynamics) {
            RecipeConstructors.greenhouseWoodRecipes(c, "integrateddynamics", "menril", "crystalized_menril_chunk");
        }
        if (Reference.ML_BiomesWeveGone) {
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "aspen");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "baobab");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "blue_enchanted");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "cika");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "cypress");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "ebony");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "fir");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "green_enchanted");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "holly");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "ironwood");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "jacaranda");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "mahogany");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "maple");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "palm");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "pine");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "rainbow_eucalyptus");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "redwood");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "skyris");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "white_mangrove");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "willow");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "witch_hazel");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "zelkova");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "palo_verde");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "_sapling", "sakura", "_log", "air", "white_");
            RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "_sapling", "sakura", "_log", "air", "yellow_");
        }
        if (Reference.ML_Occultism) {
            RecipeConstructors.greenhouseWoodRecipes(c, "occultism", "otherworld");
        }

        // Nuclear
        RecipeConstructors.fuelRodRecipes(c, "gtceu", "thorium", "evolutioncore", "thorium");
        RecipeConstructors.fuelRodRecipes(c, "gtceu", "uranium_238", "evolutioncore", "uranium_238");
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