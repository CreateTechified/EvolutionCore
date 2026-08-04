package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;

public class EvoMaterials {
    public static void init() {}

    // Materials
    public static Material Neuralium = new Material.Builder(
            EvolutionCoreMod.id("neuralium"))
            .langValue("Neuralium")
            .ingot()
            .fluid()
            .plasma()
            .element(EvoElements.Nu)
            .color(0xBD32C9)
            .iconSet(MaterialIconSet.BRIGHT)
            .flags(
                    MaterialFlags.GENERATE_PLATE,
                    MaterialFlags.GENERATE_DENSE,
                    MaterialFlags.GENERATE_ROD,
                    MaterialFlags.GENERATE_LONG_ROD,
                    MaterialFlags.GENERATE_BOLT_SCREW,
                    MaterialFlags.GENERATE_FRAME,
                    MaterialFlags.GENERATE_GEAR,
                    MaterialFlags.GENERATE_SMALL_GEAR,
                    MaterialFlags.GENERATE_FOIL,
                    MaterialFlags.GENERATE_RING,
                    MaterialFlags.GENERATE_SPRING,
                    MaterialFlags.GENERATE_SPRING_SMALL,
                    MaterialFlags.GENERATE_FINE_WIRE,
                    MaterialFlags.GENERATE_ROTOR
            )
            .buildAndRegister();

    public static Material NeuraliumInfused = new Material.Builder(
            EvolutionCoreMod.id("quantum_infused_neuralium"))
            .langValue("Quantum-Infused Neuralium")
            .gem()
            .element(EvoElements.Nu2)
            .color(0x756587)
            .iconSet(MaterialIconSet.RUBY)
            .flags(
                    MaterialFlags.GENERATE_LENS
            )
            .buildAndRegister();

    // Alloys
    public static Material NeuralicAlloy7 = new Material.Builder(
            EvolutionCoreMod.id("neuralic_alloy_7"))
            .langValue("Neuralic Alloy 7")
            .ingot()
            .fluid()
            .blastTemp(9780, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.ZPM], 6000)
            .components(EvoMaterials.Neuralium, 91, GTMaterials.Tantalum, 31, GTMaterials.Chromium, 38, GTMaterials.Bismuth, 8, GTMaterials.Iron, 17)
            .cableProperties(2097152, 2, 4, false)
            .color(0xD67CDE)
            .iconSet(MaterialIconSet.DULL)
            .flags(
                    MaterialFlags.GENERATE_PLATE,
                    MaterialFlags.GENERATE_DENSE,
                    MaterialFlags.GENERATE_ROD,
                    MaterialFlags.GENERATE_LONG_ROD,
                    MaterialFlags.GENERATE_BOLT_SCREW,
                    MaterialFlags.GENERATE_FRAME,
                    MaterialFlags.GENERATE_GEAR,
                    MaterialFlags.GENERATE_SMALL_GEAR,
                    MaterialFlags.GENERATE_FOIL,
                    MaterialFlags.GENERATE_RING,
                    MaterialFlags.GENERATE_SPRING,
                    MaterialFlags.GENERATE_SPRING_SMALL,
                    MaterialFlags.GENERATE_FINE_WIRE,
                    MaterialFlags.GENERATE_ROTOR,
                    MaterialFlags.GENERATE_ROUND
            )
            .buildAndRegister();

    public static Material ThaumiumAlloy = new Material.Builder( // Not sure if we'll keep this though, I think we will
            EvolutionCoreMod.id("thaumium_alloy"))
            .langValue("Thaumium Alloy")
            .ingot()
            .components(GTMaterials.Iron, 1, GTMaterials.Copper, 2, GTMaterials.Tin, 3, GTMaterials.Nickel, 4)
            .color(0x000000)
            .iconSet(MaterialIconSet.DULL)
            .flags(MaterialFlags.GENERATE_PLATE)
            .buildAndRegister();

    public static Material WrldappleAlloy = new Material.Builder(
            EvolutionCoreMod.id("wrldapple_alloy"))
            .langValue("Wrldapple Alloy").ingot()
            .fluid()
            .blastTemp(12980, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.OpV], 9000)
            .components(EvoMaterials.Neuralium, 87, GTMaterials.Duranium, 44, GTMaterials.SamariumIronArsenicOxide, 21, GTMaterials.Tritanium, 7, GTMaterials.Mercury, 3, GTMaterials.Neutronium, 38, EvoMaterials.NeuralicAlloy7, 13, GTMaterials.Oxygen, 12)
            .cableProperties(GTValues.V[GTValues.MAX], 512, 0, true)
            .color(0xF7EA4D)
            .secondaryColor(0xF9EBFA)
            .iconSet(MaterialIconSet.SHINY)
            .flags(
                    MaterialFlags.GENERATE_PLATE,
                    MaterialFlags.GENERATE_DENSE,
                    MaterialFlags.GENERATE_ROD,
                    MaterialFlags.GENERATE_LONG_ROD,
                    MaterialFlags.GENERATE_BOLT_SCREW,
                    MaterialFlags.GENERATE_FRAME,
                    MaterialFlags.GENERATE_GEAR,
                    MaterialFlags.GENERATE_SMALL_GEAR,
                    MaterialFlags.GENERATE_FOIL,
                    MaterialFlags.GENERATE_RING,
                    MaterialFlags.GENERATE_SPRING,
                    MaterialFlags.GENERATE_SPRING_SMALL,
                    MaterialFlags.GENERATE_FINE_WIRE,
                    MaterialFlags.GENERATE_ROTOR,
                    MaterialFlags.GENERATE_ROUND
            )
            .buildAndRegister();

    // Fluids
    public static Material QuantumInfusion = new Material.Builder(
            EvolutionCoreMod.id("quantum_infusion"))
            .langValue("Quantum Infusion")
            .liquid(new FluidBuilder().block().temperature(293))
            .color(0x372f65)
            .buildAndRegister();

    // Hidden Materials
    public static Material Energy = new Material.Builder(
            EvolutionCoreMod.id("energy"))
            .langValue("Energy")
            .gas()
            .element(EvoElements.ENERGY)
            .color(0xFAFF00)
            .iconSet(MaterialIconSet.BRIGHT)
            .buildAndRegister();

    public static Material Test = new Material.Builder(
            EvolutionCoreMod.id("test"))
            .langValue("Test")
            .ingot()
            .fluid()
            .gas()
            .plasma()
            //.ore() // Idk why red granite broke everything
            .element(EvoElements.TEST)
            .color(0xFFFFFF)
            .iconSet(MaterialIconSet.SHINY)
            .flags(
                    MaterialFlags.GENERATE_PLATE,
                    MaterialFlags.GENERATE_DENSE,
                    MaterialFlags.GENERATE_ROD,
                    MaterialFlags.GENERATE_LONG_ROD,
                    MaterialFlags.GENERATE_BOLT_SCREW,
                    MaterialFlags.GENERATE_FRAME,
                    MaterialFlags.GENERATE_GEAR,
                    MaterialFlags.GENERATE_SMALL_GEAR,
                    MaterialFlags.GENERATE_FOIL,
                    MaterialFlags.GENERATE_RING,
                    MaterialFlags.GENERATE_SPRING,
                    MaterialFlags.GENERATE_SPRING_SMALL,
                    MaterialFlags.GENERATE_FINE_WIRE,
                    MaterialFlags.GENERATE_ROTOR,
                    MaterialFlags.GENERATE_ROUND,
                    MaterialFlags.IS_MAGNETIC,
                    MaterialFlags.GENERATE_LENS
            )
            .buildAndRegister();
}
