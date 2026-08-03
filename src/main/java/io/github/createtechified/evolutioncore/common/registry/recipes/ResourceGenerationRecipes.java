package io.github.createtechified.evolutioncore.common.registry.recipes;

import io.github.createtechified.evolutioncore.common.registry.utils.RecipeConstructors;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class ResourceGenerationRecipes {
    public static void init(Consumer<FinishedRecipe> consumer) {
        RecipeConstructors.greenhouseBaseWoodRecipes(consumer,"minecraft", "oak");
        RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "minecraft", "spruce");
        RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "minecraft", "birch");
        RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "minecraft", "acacia");
        RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "minecraft", "dark_oak");
        RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "minecraft", "jungle");
        RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "minecraft", "cherry");
        RecipeConstructors.greenhouseWoodRecipes(consumer, "minecraft", "_propagule", "mangrove", "_log", "mangrove_roots");
        RecipeConstructors.greenhouseWoodRecipes(consumer, "minecraft", "_fungus", "crimson", "_stem", "nether_wart");
        RecipeConstructors.greenhouseWoodRecipes(consumer, "minecraft", "_fungus", "warped", "_stem");
        RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "gtceu", "rubber", "sticky_resin");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "integrateddynamics", "menril", "crystalized_menril_chunk");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "bomeswevegone", "aspen");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "baobab");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "blue_enchanted");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "cika");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "cypress");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "ebony");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "fir");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "green_enchanted");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "holly");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "ironwood");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "jacaranda");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "mahogany");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "maple");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "palm");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "pine");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "rainbow_eucalyptus");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "redwood");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "skyris");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "white_mangrove");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "willow");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "witch_hazel");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "zelkova");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "biomeswevegone", "palo_verde");
        //RecipeConstructors.greenhouseWoodRecipes(consumer, "biomeswevegone", "_sapling", "sakura", "_log", "air", "white_");
        //RecipeConstructors.greenhouseWoodRecipes(consumer, "biomeswevegone", "_sapling", "sakura", "_log", "air", "yellow_");
        //RecipeConstructors.greenhouseBaseWoodRecipes(consumer, "occultism", "otherworld");
    }
}