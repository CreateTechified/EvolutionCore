package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.BlastProperty;
import com.gregtechceu.gtceu.api.fluids.FluidBuilder;
import com.gregtechceu.gtceu.api.registry.registrate.entry.MaterialRegistryEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;
import static io.github.createtechified.evolutioncore.common.registry.EvoElements.*;

public class EvoMaterials {
    public static void init() {}

    // Materials
    public static MaterialRegistryEntry Neuralium = Reference.REGISTRATE.material("neuralium",builder -> builder
            .lang("Neuralium")
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
            ));

    public static MaterialRegistryEntry NeuraliumInfused = Reference.REGISTRATE.material("quantum_infused_neuralium",builder -> builder
            .lang("Quantum-Infused Neuralium")
            .gem()
            .element(Nu2)
            .color(0x756587)
            .iconSet(MaterialIconSet.RUBY)
            .flags(
                    MaterialFlags.GENERATE_LENS
            ));

    public static MaterialRegistryEntry AncientNetherite = Reference.REGISTRATE.material("ancient_netherite",builder -> builder
            .lang("Ancient Netherite")
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
            ));

    // Alloys
    public static MaterialRegistryEntry NeuralicAlloy7 = Reference.REGISTRATE.material("neuralic_alloy_7",builder -> builder
            .lang("Neuralic Alloy 7")
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
            ));

    public static MaterialRegistryEntry ThaumiumAlloy = Reference.REGISTRATE.material("thaumium_alloy",builder -> builder // Not sure if we'll keep this though, I think we will
            .lang("Thaumium Alloy")
            .ingot()
            .components(Iron, 1, Copper, 2, Tin, 3, Nickel, 4)
            .color(0x000000)
            .iconSet(MaterialIconSet.DULL)
            .flags(MaterialFlags.GENERATE_PLATE));

    public static MaterialRegistryEntry WrldappleAlloy = Reference.REGISTRATE.material("wrldapple_alloy",builder -> builder
            .lang("Wrld-Apple Alloy")
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
            ));

    // Salts
    public static MaterialRegistryEntry NeuraliumHexachloroplatinate = Reference.REGISTRATE.material("neuralium_hexachloroplatinate",builder -> builder
            .lang("Neuralium Hexachloroplatinate")
            .gem(1).ore(2, 1)
            .components(Neuralium, 1, Platinum, 1, Chlorine, 6)
            .color(0xEEC7F2)
            .iconSet(MaterialIconSet.FINE)
            .flags(
                    MaterialFlags.NO_SMASHING
            ));

    public static MaterialRegistryEntry FondorsSalt = Reference.REGISTRATE.material("nickel_neuralium_hexacyanoferrate",builder -> builder
            .lang("Fondor's Salt")
            .gem(1).ore(2, 1)
            .components(Nickel, 1, Nitrogen, 12, Hydrogen, 18, Neuralium, 1, Iron, 1, Carbon, 6)
            .color(0x82C2E8)
            .secondaryColor(0x4285B3)
            .iconSet(MaterialIconSet.FINE)
            .flags(
                    MaterialFlags.NO_SMASHING
            ));

    // Chemicals
    public static MaterialRegistryEntry Helicopter = Reference.REGISTRATE.material("helicopter",builder -> builder // the funny
            .lang("Helio-Lithic Platinide")
            .ingot()
            .liquid()
            .components(Helium, 1, Lithium, 1, Cobalt, 1, Platinum, 1, Erbium, 1)
            .color(0xD9857C)
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
                    MaterialFlags.GENERATE_FINE_WIRE,
                    MaterialFlags.GENERATE_ROTOR
            ));

    // Fluids
    public static MaterialRegistryEntry QuantumInfusion = Reference.REGISTRATE.material("quantum_infusion",builder -> builder
            .lang("Quantum Infusion")
            .liquid(new FluidBuilder().block().temperature(293))
            .color(0x372f65));

    public static MaterialRegistryEntry PotassiumNitrate = Reference.REGISTRATE.material("potassium_nitrate",builder -> builder // subjected to change, very easy to craft. yes that's a problem
            .lang("Potassium Nitrate")
            .liquid()
            .components(Potassium, 1, Nitrogen, 1, Oxygen, 3)
            .color(0x93AC72));

    // Hidden Materials
    public static MaterialRegistryEntry Energy = Reference.REGISTRATE.material("energy",builder -> builder
            .lang("Energy")
            .gas()
            .element(ENERGY)
            .color(0xFAFF00)
            .iconSet(MaterialIconSet.BRIGHT));

    public static MaterialRegistryEntry Test = Reference.REGISTRATE.material("test",builder -> builder
            .lang("Test")
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
            ));
}
