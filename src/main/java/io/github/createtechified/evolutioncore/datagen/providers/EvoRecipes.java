package io.github.createtechified.evolutioncore.datagen.providers;

import io.github.createtechified.evolutioncore.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class EvoRecipes extends RecipeProvider implements IConditionBuilder {
    public EvoRecipes(PackOutput pout) {
        super(pout);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.getItem("flint_hatchet"))
                .pattern("PF")
                .pattern("SP")
                .define('S', Items.STICK)
                .define('P', ModItems.getItem("plant_fiber"))
                .define('F', ModItems.getItem("flint_shard"))
                .unlockedBy("has_flint", has(Items.FLINT))
                .save(consumer);
    }
}
