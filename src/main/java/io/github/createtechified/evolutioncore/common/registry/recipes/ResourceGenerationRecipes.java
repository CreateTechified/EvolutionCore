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
    }
}