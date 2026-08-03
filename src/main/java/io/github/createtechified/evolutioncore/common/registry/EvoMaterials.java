package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;

public class EvoMaterials {
    public static void init() {
        NEURALIUM = new Material.Builder(
                EvolutionCoreMod.id("neuralium"))
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

        INFUSED_NEURALIUM = new Material.Builder(
                EvolutionCoreMod.id("quantum_infused_neuralium"))
                .gem()
                .element(EvoElements.Nu2)
                .color(0x756587)
                .iconSet(MaterialIconSet.RUBY)
                .flags(
                        MaterialFlags.GENERATE_LENS
                )
                .buildAndRegister();
    }
    public static Material NEURALIUM;
    public static Material INFUSED_NEURALIUM;
}
