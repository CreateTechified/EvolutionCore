package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.data.recipe.CustomTags;
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
import static com.gregtechceu.gtceu.common.data.machines.GCYMMachines.BLAST_ALLOY_SMELTER;
import static io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.electric.UpgradeMultiblocks.FUSION_ALLOYING_CHAMBER;

public class EvoRecipeInitializer {
    public static void init(Consumer<FinishedRecipe> provider) {
        // Classes
        ResourceGenerationRecipes.init(provider);

        // Ungrouped
        RecipeConstructors.pakRecipes(provider, "gtceu", "bronze", 4,
                new RecipeConstructors.AlloyIngredient("gtceu", "copper", 3),
                new RecipeConstructors.AlloyIngredient("gtceu", "tin", 1));

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
                .duration(1200).EUt(VA[ZPM]).save(provider);
    }
}
