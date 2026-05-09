package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import io.github.createtechified.evolutioncore.common.recipe.conditions.VacuumCondition;
import io.github.createtechified.evolutioncore.common.registry.ModItems;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

public class ULVSingleblockRecipes {
    public static void init(Consumer<FinishedRecipe> provider) {
        assembler(provider);
    }

    private static void assembler(Consumer<FinishedRecipe> con) {
        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder("vacuum_tube_t1")
                .inputItems(ModItems.UNSEALED_VACUUM_TUBE)
                .outputItems(GTItems.VACUUM_TUBE)
                .addCondition(new VacuumCondition(1))
                .duration(30).EUt(7).addMaterialInfo(true).save(con);
    }
}
