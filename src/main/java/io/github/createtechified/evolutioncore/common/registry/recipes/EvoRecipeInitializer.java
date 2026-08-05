package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.simibubi.create.api.data.recipe.SequencedAssemblyRecipeGen;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyRecipeBuilder;
import io.github.createtechified.evolutioncore.common.registry.utils.RecipeConstructors;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.GTValues.LuV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLY_LINE_RECIPES;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.PLASMA_GENERATOR_FUELS;
import static com.gregtechceu.gtceu.common.data.machines.GCYMMachines.BLAST_ALLOY_SMELTER;
import static io.github.createtechified.evolutioncore.common.registry.EvoMaterials.Neuralium;
import static io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.electric.UpgradeMultiblocks.FUSION_ALLOYING_CHAMBER;

public class EvoRecipeInitializer {
    public static void init(Consumer<FinishedRecipe> c) {
        // Classes
        ResourceGenerationRecipes.init(c);
        MachineShapedRecipes.init(c);

        // Ungrouped
        RecipeConstructors.pakRecipes(c, "gtceu", "bronze", 4,
                new RecipeConstructors.AlloyIngredient("gtceu", "copper", 3),
                new RecipeConstructors.AlloyIngredient("gtceu", "tin", 1));

        RecipeConstructors.fusionRecipesMK3(c, "evolutioncore",
                new RecipeConstructors.FluidIngredient("gtceu", "darmstadtium", 144),
                new RecipeConstructors.FluidIngredient("gtceu", "beryllium", 250),
                new RecipeConstructors.FluidIngredient("evolutioncore", "neuralium", 144),
                50, 420000000);

        PLASMA_GENERATOR_FUELS.recipeBuilder("neuralium")
                .inputFluids(Neuralium.getFluid(FluidStorageKeys.PLASMA, 1))
                .outputFluids(Neuralium.getFluid(FluidStorageKeys.LIQUID, 1))
                .duration(1280)
                .EUt(-2048)
                .save(c);

        ASSEMBLY_LINE_RECIPES.recipeBuilder("fusion_alloying_chamber")
                .inputItems(BLAST_ALLOY_SMELTER.asStack())
                .inputItems(plateDouble, NaquadahAlloy, 12)
                .inputItems(FIELD_GENERATOR_ZPM, 2)
                .inputItems(CustomTags.ZPM_CIRCUITS, 4)
                .inputItems(spring, Naquadah, 8)
                .inputItems(wireGtDouble, UraniumRhodiumDinaquadide, 2)
                .inputItems(screw, Naquadria, 16)
                .inputFluids(SolderingAlloy.getFluid(L * 8))
                .inputFluids(Polybenzimidazole.getFluid(L * 4))
                .outputItems(FUSION_ALLOYING_CHAMBER.asStack())
                .stationResearch(b -> b
                        .researchStack(BLAST_ALLOY_SMELTER.asStack())
                        .CWUt(20)
                        .EUt(VA[LuV]))
                .duration(1200).EUt(VA[ZPM]).save(c);
    }
}
