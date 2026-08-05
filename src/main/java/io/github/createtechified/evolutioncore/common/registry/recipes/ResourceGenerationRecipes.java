package io.github.createtechified.evolutioncore.common.registry.recipes;

import io.github.createtechified.evolutioncore.common.registry.utils.RecipeConstructors;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class ResourceGenerationRecipes {
    public static void init(Consumer<FinishedRecipe> c) {
        RecipeConstructors.greenhouseBaseWoodRecipes(c,"minecraft", "oak");
        RecipeConstructors.greenhouseBaseWoodRecipes(c, "minecraft", "spruce");
        RecipeConstructors.greenhouseBaseWoodRecipes(c, "minecraft", "birch");
        RecipeConstructors.greenhouseBaseWoodRecipes(c, "minecraft", "acacia");
        RecipeConstructors.greenhouseBaseWoodRecipes(c, "minecraft", "dark_oak");
        RecipeConstructors.greenhouseBaseWoodRecipes(c, "minecraft", "jungle");
        RecipeConstructors.greenhouseBaseWoodRecipes(c, "minecraft", "cherry");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "_propagule", "mangrove", "_log", "mangrove_roots");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "_fungus", "crimson", "_stem", "nether_wart");
        RecipeConstructors.greenhouseWoodRecipes(c, "minecraft", "_fungus", "warped", "_stem");
        RecipeConstructors.greenhouseBaseWoodRecipes(c, "gtceu", "rubber", "sticky_resin");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "integrateddynamics", "menril", "crystalized_menril_chunk");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "aspen");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "baobab");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "blue_enchanted");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "cika");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "cypress");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "ebony");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "fir");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "green_enchanted");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "holly");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "ironwood");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "jacaranda");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "mahogany"); //             Implement these all in KubeJS!
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "maple");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "palm");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "pine");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "rainbow_eucalyptus");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "redwood");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "skyris");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "white_mangrove");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "willow");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "witch_hazel");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "zelkova");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "biomeswevegone", "palo_verde");
        //RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "_sapling", "sakura", "_log", "air", "white_");
        //RecipeConstructors.greenhouseWoodRecipes(c, "biomeswevegone", "_sapling", "sakura", "_log", "air", "yellow_");
        //RecipeConstructors.greenhouseBaseWoodRecipes(c, "occultism", "otherworld");
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