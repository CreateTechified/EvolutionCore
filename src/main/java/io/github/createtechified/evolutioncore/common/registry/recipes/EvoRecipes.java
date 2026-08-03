package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.GTValues.LuV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.SUPERCONDUCTING_COIL;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.IndiumTinBariumTitaniumCuprate;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ASSEMBLY_LINE_RECIPES;
import static com.gregtechceu.gtceu.common.data.machines.GCYMMachines.BLAST_ALLOY_SMELTER;
import static com.gregtechceu.gtceu.common.data.machines.GTMultiMachines.FUSION_REACTOR;
import static io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.electric.UpgradeMultiblocks.FUSION_ALLOYING_CHAMBER;

public class EvoRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
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
