package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.common.registry.EvoBlocks;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class StoneTypeRecipes {
    public static void init(RecipeOutput c) {
        wall(c, "coke_bricks", GTBlocks.CASING_COKE_BRICKS.get(), EvoBlocks.CASING_COKE_BRICK_WALL.get());
        stair(c, "coke_bricks", GTBlocks.CASING_COKE_BRICKS.get(), EvoBlocks.CASING_COKE_BRICK_STAIRS.get());
        wall(c, "firebricks", GTBlocks.CASING_PRIMITIVE_BRICKS.get(), EvoBlocks.CASING_PRIMITIVE_BRICK_WALL.get());
        stair(c, "firebricks", GTBlocks.CASING_PRIMITIVE_BRICKS.get(), EvoBlocks.CASING_PRIMITIVE_BRICK_STAIRS.get());
    }

    private static void wall(RecipeOutput c, String name, Block source, Block wall) {
        if (ConfigHolder.INSTANCE.recipes.removeVanillaBlockRecipes) {
            VanillaRecipeHelper.addShapedRecipe(c, EvolutionCoreMod.id(name + "_wall_saw"),
                    new ItemStack(wall, 2),
                    "sS", " S", " S",
                    'S', source);
        } else {
            VanillaRecipeHelper.addShapedRecipe(c, EvolutionCoreMod.id(name + "_wall"),
                    new ItemStack(wall, 6),
                    "SSS", "SSS",
                    'S', source);
        }
        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(EvolutionCoreMod.id("assemble_" + name + "_into_wall"))
                .inputItems(source)
                .circuitMeta(13)
                .outputItems(wall)
                .duration(100)
                .EUt(8)
                .addMaterialInfo(true)
                .save(c);
    }

    private static void stair(RecipeOutput c, String name, Block source, Block stair) {
        if (ConfigHolder.INSTANCE.recipes.removeVanillaBlockRecipes) {
            VanillaRecipeHelper.addShapedRecipe(c, EvolutionCoreMod.id(name + "_stair_saw"),
                    new ItemStack(stair, 3),
                    "Ss ", "SS ", "SSS",
                    'S', source);
        } else {
            VanillaRecipeHelper.addShapedRecipe(c, EvolutionCoreMod.id(name + "_stair"),
                    new ItemStack(stair, 4),
                    "S  ", "SS ", "SSS",
                    'S', source);
        }
        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(EvolutionCoreMod.id("assemble_" + name + "_into_stair"))
                .inputItems(source, 3)
                .circuitMeta(7)
                .outputItems(stair, 4)
                .duration(80)
                .EUt(8)
                .addMaterialInfo(true)
                .save(c);
    }
}
