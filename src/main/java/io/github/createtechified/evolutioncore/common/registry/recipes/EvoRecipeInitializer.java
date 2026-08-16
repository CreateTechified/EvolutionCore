package io.github.createtechified.evolutioncore.common.registry.recipes;

import appeng.core.definitions.AEItems;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import io.github.createtechified.evolutioncore.common.registry.EvoItems;
import io.github.createtechified.evolutioncore.common.registry.utils.RecipeConstructors;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_STEEL_TURBINE;
import static com.gregtechceu.gtceu.common.data.GTItems.*;
import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;
import static com.gregtechceu.gtceu.common.data.machines.GCYMMachines.*;
import static io.github.createtechified.evolutioncore.common.registry.EvoBlocks.*;
import static io.github.createtechified.evolutioncore.common.registry.EvoMaterials.*;
import static io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.electric.UpgradeMultiblocks.*;
import static io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes.*;
import static io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes.LARGE_CHEMICAL_PLANT;

public class EvoRecipeInitializer {
    public static void init(Consumer<FinishedRecipe> c) {
        // Classes
        ResourceGenerationRecipes.init(c);
        MachineShapedRecipes.init(c);

        // Stainless Steel Casings
        ASSEMBLER_RECIPES.recipeBuilder("stainless_steel_firebox_casing")
                .inputItems(rod, StainlessSteel, 3)
                .inputItems(frameGt, StainlessSteel)
                .inputItems(plate, StainlessSteel, 3)
                .outputItems(STAINLESS_STEEL_FIREBOX_CASING.asStack(2))
                .duration(300)
                .EUt(120)
                .save(c);

        // Naquadah Alloy Casings
        ASSEMBLER_RECIPES.recipeBuilder("naquadah_alloy_machine_casing")
                .inputItems(plate, NaquadahAlloy, 6)
                .inputItems(frameGt, NaquadahAlloy)
                .outputItems(NAQUADAH_ALLOY_MACHINE_CASING.asStack(2))
                .duration(50)
                .EUt(16)
                .circuitMeta(6)
                .save(c);

        ASSEMBLER_RECIPES.recipeBuilder("naquadah_alloy_gearbox")
                .inputItems(plate, NaquadahAlloy, 4)
                .inputItems(gear, NaquadahAlloy, 2)
                .inputItems(frameGt, NaquadahAlloy)
                .outputItems(NAQUADAH_ALLOY_GEARBOX_CASING.asStack(2))
                .duration(50)
                .EUt(16)
                .circuitMeta(4)
                .save(c);

        ASSEMBLER_RECIPES.recipeBuilder("naquadah_alloy_firebox_casing")
                .inputItems(rod, NaquadahAlloy, 3)
                .inputItems(frameGt, NaquadahAlloy)
                .inputItems(plate, NaquadahAlloy, 3)
                .outputItems(NAQUADAH_ALLOY_FIREBOX_CASING.asStack(2))
                .duration(500)
                .EUt(30720)
                .save(c);

        ASSEMBLER_RECIPES.recipeBuilder("ludicrous_engine_intake_casing")
                .inputItems(rotor, NaquadahAlloy, 2)
                .inputItems(pipeNormalFluid, NaquadahAlloy, 4)
                .inputItems(NAQUADAH_ALLOY_MACHINE_CASING.asStack())
                .outputItems(LUDICROUS_ENGINE_INTAKE_CASING.asStack(2))
                .duration(50)
                .EUt(16)
                .save(c);

        ASSEMBLER_RECIPES.recipeBuilder("naquadah_alloy_turbine_casing")
                .inputItems(CASING_STEEL_TURBINE.asStack())
                .inputItems(plate, NaquadahAlloy, 6)
                .outputItems(NAQUADAH_ALLOY_TURBINE_CASING.asStack(2))
                .duration(50)
                .EUt(16)
                .circuitMeta(6)
                .save(c);

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
                .duration(1200)
                .EUt(VA[ZPM])
                .save(c);

        CHEMICAL_LINE_REDUCTION.recipeBuilder("plat_line_reduced")
                .inputItems(dust, PlatinumGroupSludge, 18)
                .inputFluids(AquaRegia.getFluid(1500)) // subjected to change
                .outputItems(dust, Platinum, 3)
                .outputItems(dust, Palladium, 3)
                .outputItems(dust, Rhodium, 2)
                .outputItems(dust, Ruthenium, 2)
                .outputItems(dust, Iridium, 1)
                .outputItems(dust, Osmium, 1)
                .outputFluids(NitricAcid.getFluid(500))
                .outputFluids(HydrochloricAcid.getFluid(1000))
                .duration(300)
                .EUt(GTValues.VA[GTValues.ZPM])
                .circuitMeta(5)
                .save(c);

        LARGE_CHEMICAL_PLANT.recipeBuilder("quantum_infusion")
                .inputItems(AEItems.SINGULARITY)
                .inputItems(dustSmall, IndiumGalliumPhosphide)
                .inputFluids(Radon.getFluid(6250))
                .inputFluids(AmmoniumFormate.getFluid(1500))
                .inputFluids(McGuffium239.getFluid(750)) // The forgotten GT Chemical, needs recipe(s) though
                .outputFluids(QuantumInfusion.getFluid(1500))
                .duration(300)
                .EUt(GTValues.VA[GTValues.ZPM])
                .circuitMeta(2)
                .save(c);

        VACUUM_CHAMBER_RECIPES.recipeBuilder("sealed_vacuum_tube")
                .inputItems(EvoItems.UNSEALED_VACUUM_TUBE)
                .outputItems(GTItems.VACUUM_TUBE)
                .duration(300)
                .EUt(GTValues.VA[GTValues.ULV])
                .save(c);
    }
}
