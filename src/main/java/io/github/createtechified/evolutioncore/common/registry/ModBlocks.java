package io.github.createtechified.evolutioncore.common.registry;

import io.github.createtechified.evolutioncore.Reference;

public class ModBlocks {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> CreativeTabs.EVOLUTIONCORE_MAIN);
    }
}
