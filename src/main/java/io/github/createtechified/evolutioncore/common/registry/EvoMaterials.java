package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static io.github.createtechified.evolutioncore.common.registry.EvoElements.*;

public class EvoMaterials {
    public static void init() {Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MATERIALS);}

    // Materials
    public static Material Neuralium = new Material.Builder(
            EvolutionCoreMod.id("neuralium"))
            .langValue("Neuralium")
            .ingot()
            .fluid()
            .plasma()
            .element(Nu)
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
            .element(Nu2)
            .color(0x756587)
            .iconSet(MaterialIconSet.RUBY)
            .flags(
                    MaterialFlags.GENERATE_LENS
            )
            .buildAndRegister();

    public static Material AncientNetherite = new Material.Builder(
            EvolutionCoreMod.id("ancient_netherite"))
            .langValue("Ancient Netherite")
            .ingot()
            .element(Nr2)
            .color(0x292222)
            .iconSet(MaterialIconSet.RADIOACTIVE) // Not really radioactive but ok
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
                    MaterialFlags.GENERATE_ROTOR
            )
            .buildAndRegister();

    // Alloys
    public static Material NeuralicAlloy7 = new Material.Builder(
            EvolutionCoreMod.id("neuralic_alloy_7"))
            .langValue("Neuralic Alloy 7")
            .ingot()
            .fluid()
            .blastTemp(9780, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.ZPM], 6000)
            .components(Neuralium, 91, Tantalum, 31, Chromium, 38, Bismuth, 8, Iron, 17)
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
            .components(Iron, 1, Copper, 2, Tin, 3, Nickel, 4)
            .color(0x000000)
            .iconSet(MaterialIconSet.DULL)
            .flags(MaterialFlags.GENERATE_PLATE)
            .buildAndRegister();

    public static Material WrldappleAlloy = new Material.Builder(
            EvolutionCoreMod.id("wrldapple_alloy"))
            .langValue("Wrld-Apple Alloy")
            .ingot()
            .fluid()
            .blastTemp(12980, BlastProperty.GasTier.HIGHEST, GTValues.VA[GTValues.OpV], 9000)
            .components(Neuralium, 87, Duranium, 44, SamariumIronArsenicOxide, 21, Tritanium, 7, Mercury, 3, Neutronium, 38, NeuralicAlloy7, 13, Oxygen, 12)
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

    public static Material PotassiumNitrate = new Material.Builder( // subjected to change, very easy to craft. yes that's a problem
            EvolutionCoreMod.id("potassium_nitrate"))
            .langValue("Potassium Nitrate")
            .liquid()
            .components(Potassium, 1, Nitrogen, 1, Oxygen, 3)
            .color(0x93AC72)
            .buildAndRegister();

    // Hidden Materials
    public static Material Energy = new Material.Builder(
            EvolutionCoreMod.id("energy"))
            .langValue("Energy")
            .gas()
            .element(ENERGY)
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
            .element(TEST)
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
