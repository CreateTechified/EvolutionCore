package io.github.createtechified.evolutioncore.common.registry.utils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.function.Consumer;

public class RecipeConstructors {
    public static void greenhouseBaseWoodRecipes(Consumer<FinishedRecipe> consumer, String id, Item sapling, ItemStack... outputs) {
        EvoRecipeTypes.STEEL_GREENHOUSE.recipeBuilder(EvolutionCoreMod.id(id)).notConsumable(sapling)
                .inputFluids(GTMaterials.Water.getFluid(1000)).outputItems(outputs).circuitMeta(1).duration(640).EUt(GTValues.VA[GTValues.LV]).save(consumer);
    }
    public static void greenhouseBaseWoodRecipes(Consumer<FinishedRecipe> consumer, String namespace, String wood) {
        greenhouseBaseWoodRecipes(
                consumer,
                wood,
                GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_sapling"),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_log"), 64)
        );
    }
    public static void greenhouseBaseWoodRecipes(Consumer<FinishedRecipe> consumer, String namespace, String wood, String byproduct) {
        greenhouseBaseWoodRecipes(
                consumer,
                wood,
                GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_sapling"),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_log"), 64),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, byproduct), 16)
        );
    }

    public static void greenhouseWoodRecipes(Consumer<FinishedRecipe> consumer, String id, Item sapling, ItemStack... outputs) {
        EvoRecipeTypes.STEEL_GREENHOUSE.recipeBuilder(EvolutionCoreMod.id(id)).notConsumable(sapling)
                .inputFluids(GTMaterials.Water.getFluid(1000)).outputItems(outputs).circuitMeta(1).duration(640).EUt(GTValues.VA[GTValues.LV]).save(consumer);
    }
    public static void greenhouseWoodRecipes(Consumer<FinishedRecipe> consumer, String namespace, String sapling_prefix, String wood, String wood_prefix) {
        greenhouseBaseWoodRecipes(
                consumer,
                wood,
                GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + sapling_prefix),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + wood_prefix), 64)
        );
    }
    public static void greenhouseWoodRecipes(Consumer<FinishedRecipe> consumer, String namespace, String sapling_prefix, String wood, String wood_prefix, String byproduct) {
        greenhouseBaseWoodRecipes(
                consumer,
                wood,
                GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + sapling_prefix),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + wood_prefix), 64),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, byproduct), 16)
        );
    }
    public static void greenhouseWoodRecipes(Consumer<FinishedRecipe> consumer, String namespace, String sapling_prefix, String wood, String wood_prefix, String byproduct, String sapling_suffix) {
        greenhouseBaseWoodRecipes(
                consumer,
                wood,
                GeneralHelpers.getItemFromNamespaceAndID(namespace, sapling_suffix + wood + sapling_prefix),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + wood_prefix), 64),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, byproduct), 16)
        );
    }

    public record AlloyIngredient(String namespace, String material, int count) {}
    public static void pakRecipes(Consumer<FinishedRecipe> consumer, String id, ItemStack[] inputs, ItemStack output) {
        EvoRecipeTypes.PRIMITIVE_ALLOY_SMELTER.recipeBuilder(EvolutionCoreMod.id(id))
                .inputItems(inputs)
                .outputItems(output)
                .duration(640)
                .save(consumer);
    }
    public static void pakRecipes(Consumer<FinishedRecipe> consumer, String outputNamespace, String materialOut, int outputCount, AlloyIngredient... ingredients) {
        ItemStack[] inputs = new ItemStack[ingredients.length];
        for (int i = 0; i < ingredients.length; i++) {
            AlloyIngredient ing = ingredients[i];
            inputs[i] = new ItemStack(
                    GeneralHelpers.getItemFromNamespaceAndID(ing.namespace(), ing.material() + "_dust"),
                    ing.count()
            );
        }

        ItemStack output = new ItemStack(
                GeneralHelpers.getItemFromNamespaceAndID(outputNamespace, materialOut + "_dust"),
                outputCount
        );

        String id = outputNamespace + "_" + materialOut + "_alloy";

        pakRecipes(consumer, id, inputs, output);
    }

    public record FluidIngredient(String namespace, String fluid, int amount) {}

    private static FluidStack resolveFluidStack(FluidIngredient ingredient) {
        return new FluidStack(
                GeneralHelpers.getFluidFromNamespaceAndID(ingredient.namespace(), ingredient.fluid()),
                ingredient.amount()
        );
    }
    public static void fusionRecipesMK3(Consumer<FinishedRecipe> consumer, String id, FluidStack[] inputs, FluidStack output, int duration, int euStart) {
        GTRecipeTypes.FUSION_RECIPES.recipeBuilder(EvolutionCoreMod.id(id))
                .inputFluids(inputs)
                .outputFluids(output)
                .duration(duration)
                .fusionStartEU(euStart)
                .EUt(GTValues.VA[GTValues.UV])
                .save(consumer);
    }
    public static void fusionRecipesMK3(Consumer<FinishedRecipe> consumer, String id,
                                        FluidIngredient input1, FluidIngredient input2,
                                        FluidIngredient output, int duration, int euStart) {
        FluidStack[] inputs = new FluidStack[] {
                resolveFluidStack(input1),
                resolveFluidStack(input2)
        };
        FluidStack outputStack = resolveFluidStack(output);

        fusionRecipesMK3(consumer, id, inputs, outputStack, duration, euStart);
    }
}
