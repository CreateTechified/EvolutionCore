package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;

import static com.gregtechceu.gtceu.common.data.GTElements.createAndRegister;

public class EvoElements {
    public static void init() {}

    public static final Element Nu = createAndRegister(
            EvolutionCoreMod.id("neuralium"),
            119, 126, -1, null,
            "Neuralium", "Nu", false
    );
    public static final Element Nu2 = createAndRegister(
            EvolutionCoreMod.id("quantum_infused_neuralium"),
            119, 128, -1, null,
            "Quantum Infused Neuralium", "Nu→", true
    );
    public static final Element Nr2 = createAndRegister( // Technically we never really added Nr.. but still we call it Nr2, just for the sake of simplicity. Also don't ask me why I added this :D
            EvolutionCoreMod.id("ancient_netherite"),
            127, 139, -1 , null,
            "Ancient Netherite", "*Nr*", true
    );

    // Hidden Elements
    // Don't tell me they exist, but treat 'em as a picture of a coconut. I see how it is...
    public static final Element ENERGY = createAndRegister(
            EvolutionCoreMod.id("energy"),
            0, 0, -1, null,
            "Energy", "⚡", false
    );
    public static final Element TEST = createAndRegister(
            EvolutionCoreMod.id("test_element"),
            200, 200, -1, null,
            "Test", "Em", false
    );
}