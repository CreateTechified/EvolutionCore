package io.github.createtechified.evolutioncore.common.registry.utils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fluids.FluidStack;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.L;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.CarbonDioxide;
import static io.github.createtechified.evolutioncore.common.registry.EvoMaterials.PotassiumNitrate;

public class RecipeConstructors {
    public static void greenhouseBaseWoodRecipes(Consumer<FinishedRecipe> consumer, String id, Item sapling, ItemStack... outputs) {
        EvoRecipeTypes.STEEL_GREENHOUSE.recipeBuilder(EvolutionCoreMod.id(id)).notConsumable(sapling)
                .inputFluids(Water.getFluid(1000)).outputItems(outputs).circuitMeta(1).duration(640).EUt(GTValues.VA[GTValues.LV]).save(consumer);
    }
    public static void greenhouseBaseWoodRecipes2(Consumer<FinishedRecipe> consumer, String id, Item sapling, ItemStack... outputs) {
        EvoRecipeTypes.STEEL_GREENHOUSE.recipeBuilder(EvolutionCoreMod.id(id)).notConsumable(sapling)
                .inputFluids(Water.getFluid(1000)).inputFluids(CarbonDioxide.getFluid(1250)).outputItems(outputs).circuitMeta(2).duration(640).EUt(GTValues.VA[GTValues.MV]).save(consumer);
    }
    public static void greenhouseBaseWoodRecipes3(Consumer<FinishedRecipe> consumer, String id, Item sapling, ItemStack... outputs) {
        EvoRecipeTypes.STEEL_GREENHOUSE.recipeBuilder(EvolutionCoreMod.id(id)).notConsumable(sapling)
                .inputFluids(Water.getFluid(1000)).inputFluids(CarbonDioxide.getFluid(1250)).inputFluids(PotassiumNitrate.getFluid(1500)).outputItems(outputs).circuitMeta(3).duration(640).EUt(GTValues.VA[GTValues.HV]).save(consumer);
    }
    public static void greenhouseWoodRecipes(Consumer<FinishedRecipe> consumer, String namespace, String wood) {
        greenhouseBaseWoodRecipes(consumer, wood + "_1", GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_sapling"),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_log"), 64)
        );
        greenhouseBaseWoodRecipes2(consumer, wood + "_2", GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_sapling"),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_log"), 128)
        );
        greenhouseBaseWoodRecipes3(consumer, wood + "_3", GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_sapling"),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_log"), 256)
        );
    }
    public static void greenhouseWoodRecipes(Consumer<FinishedRecipe> consumer, String namespace, String wood, String byproduct) {
        greenhouseBaseWoodRecipes(consumer, wood + "_1", GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_sapling"),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_log"), 64),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, byproduct), 16)
        );
        greenhouseBaseWoodRecipes2(consumer, wood + "_2", GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_sapling"),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_log"), 128),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, byproduct), 32)
        );
        greenhouseBaseWoodRecipes3(consumer, wood + "_3", GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_sapling"),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + "_log"), 256),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, byproduct), 64)
        );
    }
    public static void greenhouseWoodRecipes(Consumer<FinishedRecipe> consumer, String namespace, String sapling_prefix, String wood, String wood_prefix) {
        greenhouseBaseWoodRecipes(consumer, wood + "_1", GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + sapling_prefix),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + wood_prefix), 64)
        );
        greenhouseBaseWoodRecipes2(consumer, wood + "_2", GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + sapling_prefix),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + wood_prefix), 128)
        );
        greenhouseBaseWoodRecipes3(consumer, wood + "_3", GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + sapling_prefix),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + wood_prefix), 256)
        );
    }
    public static void greenhouseWoodRecipes(Consumer<FinishedRecipe> consumer, String namespace, String sapling_prefix, String wood, String wood_prefix, String byproduct) {
        greenhouseBaseWoodRecipes(consumer, wood + "_1", GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + sapling_prefix),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + wood_prefix), 64),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, byproduct), 16)
        );
        greenhouseBaseWoodRecipes2(consumer, wood + "_2", GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + sapling_prefix),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + wood_prefix), 128),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, byproduct), 32)
        );
        greenhouseBaseWoodRecipes3(consumer, wood + "_3", GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + sapling_prefix),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + wood_prefix), 256),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, byproduct), 64)
        );
    }
    public static void greenhouseWoodRecipes(Consumer<FinishedRecipe> consumer, String namespace, String sapling_prefix, String wood, String wood_prefix, String byproduct, String sapling_suffix) {
        greenhouseBaseWoodRecipes(consumer, wood + "_1", GeneralHelpers.getItemFromNamespaceAndID(namespace, sapling_suffix + wood + sapling_prefix),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + wood_prefix), 64),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, byproduct), 16)
        );
        greenhouseBaseWoodRecipes2(consumer, wood + "_2", GeneralHelpers.getItemFromNamespaceAndID(namespace, sapling_suffix + wood + sapling_prefix),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + wood_prefix), 128),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, byproduct), 32)
        );
        greenhouseBaseWoodRecipes3(consumer, wood + "_3", GeneralHelpers.getItemFromNamespaceAndID(namespace, sapling_suffix + wood + sapling_prefix),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, wood + wood_prefix), 256),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespace, byproduct), 64)
        );

    }

    public record AlloyIngredient(String namespace, String material, int count) {}
    public static void pakRecipes(Consumer<FinishedRecipe> consumer, String id, ItemStack[] inputs, ItemStack output) {
        EvoRecipeTypes.PRIMITIVE_ALLOY_SMELTER.recipeBuilder(EvolutionCoreMod.id(id))
                .inputItems(inputs)
                .inputItems(new ItemStack(Items.COAL, 2))
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

    public static void fuelRodRecipes(Consumer<FinishedRecipe> consumer, String id, Item input, ItemStack... output) {
        GTRecipeTypes.CANNER_RECIPES.recipeBuilder(EvolutionCoreMod.id(id))
                .inputItems(input)
                .inputItems(GTItems.FLUID_CELL_LARGE_STAINLESS_STEEL)
                .inputFluids(SolderingAlloy.getFluid(L * 4))
                .outputItems(output)
                .duration(100)
                .EUt(GTValues.VA[GTValues.HV])
                .save(consumer);
    }
    public static void fuelRodRecipes(Consumer<FinishedRecipe> consumer, String namespaceIN, String fuelType, String namespaceOUT, String fuelRodType) {
        fuelRodRecipes(
                consumer,
                fuelType,
                GeneralHelpers.getItemFromNamespaceAndID(namespaceIN, fuelType + "_dust"),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespaceOUT, fuelRodType + "_fuel_rod"), 1)
        );
    }

    public static void depletedFuelRodRecipes(Consumer<FinishedRecipe> consumer, String id, Item input, FluidStack[] outputFluids, ItemStack... outputItems) {
        GTRecipeTypes.CENTRIFUGE_RECIPES.recipeBuilder(EvolutionCoreMod.id(id))
                .inputItems(input)
                .outputItems(outputItems)
                .outputItems(GTItems.FLUID_CELL_LARGE_STAINLESS_STEEL)
                .outputFluids(outputFluids)
                .duration(200)
                .EUt(GTValues.VA[GTValues.HV])
                .save(consumer);
    }
    public static void depletedFuelRodRecipes(Consumer<FinishedRecipe> consumer, String namespaceIN, String fuelRodType, String namespaceItemsOUT1, String itemsOUT1, String namespaceItemsOUT2, String itemsOUT2) {
        depletedFuelRodRecipes(
                consumer,
                fuelRodType,
                GeneralHelpers.getItemFromNamespaceAndID(namespaceIN, "depleted_" + fuelRodType + "_fuel_rod"),
                new FluidStack[0],
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespaceItemsOUT1, itemsOUT1 + "_dust"), 1),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespaceItemsOUT2, itemsOUT2 + "_dust"), 1)
        );
    }
    public static void depletedFuelRodRecipes(Consumer<FinishedRecipe> consumer, String namespaceIN, String fuelRodType, String namespaceItemsOUT1, String itemsOUT1, String namespaceItemsOUT2, String itemsOUT2, String namespaceFluidsOUT1, String fluidsOUT1) {
        depletedFuelRodRecipes(
                consumer,
                fuelRodType,
                GeneralHelpers.getItemFromNamespaceAndID(namespaceIN, "depleted_" + fuelRodType + "_fuel_rod"),
                new FluidStack[] {
                        resolveFluidStack(new FluidIngredient(namespaceFluidsOUT1, fluidsOUT1, L * 4))
                },
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespaceItemsOUT1, itemsOUT1 + "_dust"), 1),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespaceItemsOUT2, itemsOUT2 + "_dust"), 1)
        );
    }
    public static void depletedFuelRodRecipes(Consumer<FinishedRecipe> consumer, String namespaceIN, String fuelRodType, String namespaceItemsOUT1, String itemsOUT1, String namespaceItemsOUT2, String itemsOUT2, String namespaceFluidsOUT1, String fluidsOUT1, String namespaceFluidsOUT2, String fluidsOUT2) {
        depletedFuelRodRecipes(
                consumer,
                fuelRodType,
                GeneralHelpers.getItemFromNamespaceAndID(namespaceIN, "depleted_" + fuelRodType + "_fuel_rod"),
                new FluidStack[] {
                        resolveFluidStack(new FluidIngredient(namespaceFluidsOUT1, fluidsOUT1, L * 4)),
                        resolveFluidStack(new FluidIngredient(namespaceFluidsOUT2, fluidsOUT2, L * 4))
                },
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespaceItemsOUT1, itemsOUT1 + "_dust"), 1),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespaceItemsOUT2, itemsOUT2 + "_dust"), 1)
        );
    }

    public static void simpleFissionReactions(Consumer<FinishedRecipe> consumer, String id, Item input, ItemStack output, int energy) {
        EvoRecipeTypes.FISSION_REACTOR_FUELS.recipeBuilder(EvolutionCoreMod.id(id))
                .inputItems(input)
                .perTick(true)
                .inputFluids(Water.getFluid(1000))
                .perTick(false)
                .outputItems(output)
                .duration(320)
                .EUt(energy)
                .save(consumer);
    }
    public static void simpleFissionReactions(Consumer<FinishedRecipe> consumer, String namespaceIN, String fuelRodType, String namespaceOUT, String depletedFuelRodType, int energy) {
        simpleFissionReactions(
                consumer,
                fuelRodType,
                GeneralHelpers.getItemFromNamespaceAndID(namespaceIN, fuelRodType + "_fuel_rod"),
                new ItemStack(GeneralHelpers.getItemFromNamespaceAndID(namespaceOUT, "depleted_" + depletedFuelRodType + "_fuel_rod"), 1),
                energy
        );
    }
}
