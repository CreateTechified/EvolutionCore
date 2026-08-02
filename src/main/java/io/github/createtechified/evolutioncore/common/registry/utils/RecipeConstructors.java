package io.github.createtechified.evolutioncore.common.registry.utils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class RecipeConstructors {
    public static void greenhouseBaseWoodRecipes(RecipeOutput consumer, String id, Item sapling, ItemStack... outputs) {
        EvoRecipeTypes.STEEL_GREENHOUSE.recipeBuilder(EvolutionCoreMod.id(id)).notConsumable(sapling)
                .inputFluids(GTMaterials.Water.getFluid(1000)).outputItems(outputs).circuitMeta(1).duration(640).EUt(GTValues.VA[GTValues.LV]).save(consumer);
    }
    public static void greenhouseBaseWoodRecipes(RecipeOutput consumer, String namespace, String wood) {
        greenhouseBaseWoodRecipes(consumer, wood, GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_sapling"), new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_log"), 64));
    }
}
