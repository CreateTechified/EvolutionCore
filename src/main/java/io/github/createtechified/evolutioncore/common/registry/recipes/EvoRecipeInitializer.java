package io.github.createtechified.evolutioncore.common.registry.recipes;

import appeng.core.definitions.AEItems;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.fluids.store.FluidStorageKeys;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.common.registry.EvoItems;
import io.github.createtechified.evolutioncore.common.registry.utils.RecipeConstructors;
import net.minecraft.data.recipes.RecipeOutput;

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
    public static void init(RecipeOutput c) {
        // Classes
        StoneTypeRecipes.init(c);
        ResourceGenerationRecipes.init(c);
        MachineShapedRecipes.init(c);
        pbfRecipes(c);

        // Stainless Steel Casings
        ASSEMBLER_RECIPES.recipeBuilder(EvolutionCoreMod.id("stainless_steel_firebox_casing"))
                .inputItems(rod, StainlessSteel, 3)
                .inputItems(frameGt, StainlessSteel)
                .inputItems(plate, StainlessSteel, 3)
                .outputItems(STAINLESS_STEEL_FIREBOX_CASING.asStack(2))
                .duration(300)
                .EUt(120)
                .save(c);

        // Naquadah Alloy Casings
        ASSEMBLER_RECIPES.recipeBuilder(EvolutionCoreMod.id("naquadah_alloy_machine_casing"))
                .inputItems(plate, NaquadahAlloy, 6)
                .inputItems(frameGt, NaquadahAlloy)
                .outputItems(NAQUADAH_ALLOY_MACHINE_CASING.asStack(2))
                .duration(50)
                .EUt(16)
                .circuitMeta(6)
                .save(c);

        ASSEMBLER_RECIPES.recipeBuilder(EvolutionCoreMod.id("naquadah_alloy_gearbox"))
                .inputItems(plate, NaquadahAlloy, 4)
                .inputItems(gear, NaquadahAlloy, 2)
                .inputItems(frameGt, NaquadahAlloy)
                .outputItems(NAQUADAH_ALLOY_GEARBOX_CASING.asStack(2))
                .duration(50)
                .EUt(16)
                .circuitMeta(4)
                .save(c);

        ASSEMBLER_RECIPES.recipeBuilder(EvolutionCoreMod.id("naquadah_alloy_firebox_casing"))
                .inputItems(rod, NaquadahAlloy, 3)
                .inputItems(frameGt, NaquadahAlloy)
                .inputItems(plate, NaquadahAlloy, 3)
                .outputItems(NAQUADAH_ALLOY_FIREBOX_CASING.asStack(2))
                .duration(500)
                .EUt(30720)
                .save(c);

        ASSEMBLER_RECIPES.recipeBuilder(EvolutionCoreMod.id("ludicrous_engine_intake_casing"))
                .inputItems(rotor, NaquadahAlloy, 2)
                .inputItems(pipeNormalFluid, NaquadahAlloy, 4)
                .inputItems(NAQUADAH_ALLOY_MACHINE_CASING.asStack())
                .outputItems(LUDICROUS_ENGINE_INTAKE_CASING.asStack(2))
                .duration(50)
                .EUt(16)
                .save(c);

        ASSEMBLER_RECIPES.recipeBuilder(EvolutionCoreMod.id("naquadah_alloy_turbine_casing"))
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

        FUSION_RECIPES.recipeBuilder(EvolutionCoreMod.id("darmstadtium_and_beryllium_to_neuralium_plasma"))
                .inputFluids(Darmstadtium.getFluid(FluidStorageKeys.LIQUID, 144))
                .inputFluids(Beryllium.getFluid(FluidStorageKeys.LIQUID, 250))
                .outputFluids(Neuralium.getFluid(FluidStorageKeys.PLASMA, 144))
                .duration(50)
                .EUt(GTValues.VA[GTValues.UHV])
                .fusionStartEU(420000000)
                .save(c);

        PLASMA_GENERATOR_FUELS.recipeBuilder(EvolutionCoreMod.id("neuralium"))
                .inputFluids(Neuralium.getFluid(FluidStorageKeys.PLASMA, 1))
                .outputFluids(Neuralium.getFluid(FluidStorageKeys.LIQUID, 1))
                .duration(1280)
                .EUt(-2048)
                .save(c);

        ASSEMBLY_LINE_RECIPES.recipeBuilder(EvolutionCoreMod.id("fusion_alloying_chamber"))
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

        // can this be its own multiblock? like GTNL's Platinum Group Processing Hub...
        CHEMICAL_LINE_REDUCTION.recipeBuilder(EvolutionCoreMod.id("plat_line_reduced"))
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
                .EUt(VA[ZPM])
                .circuitMeta(5)
                .save(c);

        LARGE_CHEMICAL_PLANT.recipeBuilder(EvolutionCoreMod.id("quantum_infusion"))
                .inputItems(AEItems.SINGULARITY)
                .inputItems(dustSmall, IndiumGalliumPhosphide)
                .inputFluids(Radon.getFluid(6250))
                .inputFluids(AmmoniumFormate.getFluid(1500))
                .inputFluids(McGuffium239.getFluid(750)) // The forgotten GT Chemical, needs recipe(s) though
                .outputFluids(QuantumInfusion.getFluid(1500))
                .duration(300)
                .EUt(VA[ZPM])
                .circuitMeta(2)
                .save(c);

        VACUUM_CHAMBER_RECIPES.recipeBuilder(EvolutionCoreMod.id("sealed_vacuum_tube"))
                .inputItems(EvoItems.UNSEALED_VACUUM_TUBE)
                .outputItems(VACUUM_TUBE)
                .duration(300)
                .EUt(VA[ULV])
                .save(c);

        CENTRIFUGE_RECIPES.recipeBuilder(EvolutionCoreMod.id("failed_vacuum_tube_recycling"))
                .inputItems(EvoItems.FAILED_VACUUM_TUBE_PARTS)
                .chancedOutput(GLASS_TUBE.get(), 1, "1/4") // add more outs later
                .duration(1200)
                .EUt(VA[ULV])
                .save(c);
    }

    private static void pbfRecipes(RecipeOutput provider) {
        PRIMITIVE_BLAST_FURNACE.recipeBuilder(EvolutionCoreMod.id("steel_iron"))
                .inputItems(ingot, Iron).outputItems(ingot, Steel).outputItems(dustTiny, DarkAsh, 2).duration(1600)
                .save(provider);

        PRIMITIVE_BLAST_FURNACE.recipeBuilder(EvolutionCoreMod.id("steel_iron_block"))
                .inputItems(block, Iron).outputItems(block, Steel).outputItems(dust, DarkAsh, 2).duration(16000)
                .save(provider);

        PRIMITIVE_BLAST_FURNACE.recipeBuilder(EvolutionCoreMod.id("steel_wrought_iron"))
                .inputItems(ingot, WroughtIron).outputItems(ingot, Steel).outputItems(dustTiny, DarkAsh, 2).duration(800)
                .save(provider);

        PRIMITIVE_BLAST_FURNACE.recipeBuilder(EvolutionCoreMod.id("steel_wrought_iron_block"))
                .inputItems(block, WroughtIron).outputItems(block, Steel).outputItems(dust, DarkAsh, 2).duration(8000)
                .save(provider);
    }
}
