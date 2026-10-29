package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.data.chemical.Element;
import com.tterrag.registrate.util.entry.RegistryEntry;
import io.github.createtechified.evolutioncore.Reference;

public class EvoElements {
    public static void init() {}

    public static final RegistryEntry<Element, Element> Nu =  Reference.REGISTRATE.element(
            "neuralium",
            119, 126, -1, null,
            "Neuralium", "Nu", false
    );
    public static final RegistryEntry<Element, Element> Nu2 =  Reference.REGISTRATE.element(
            "quantum_infused_neuralium",
            119, 128, -1, null,
            "Quantum-Infused Neuralium", "Nu→", true
    );
    public static final RegistryEntry<Element, Element> Nr2 =  Reference.REGISTRATE.element( // Technically we never really added Nr.. but still we call it Nr2, just for the sake of simplicity. Also don't ask me why I added this :D
            "ancient_netherite",
            127, 139, -1 , null,
            "Ancient Netherite", "*Nr*", true
    );

    // Hidden Elements
    // Don't tell me they exist, but treat 'em as a picture of a coconut. I see how it is...
    public static final RegistryEntry<Element, Element> ENERGY =  Reference.REGISTRATE.element(
            "energy",
            0, 0, -1, null,
            "Energy", "⚡", false
    );
    public static final RegistryEntry<Element, Element> TEST =  Reference.REGISTRATE.element(
            "test_element",
            200, 200, -1, null,
            "Test", "Em", false
    );
}