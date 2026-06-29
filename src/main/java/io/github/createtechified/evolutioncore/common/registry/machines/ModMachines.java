package io.github.createtechified.evolutioncore.common.registry.machines;

import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.CreativeTabs;

public class ModMachines {
    static {
        Reference.REGISTRATE.creativeModeTab(() -> CreativeTabs.EVOLUTIONCORE_MAIN);
    }

    public static void init() {
        GTMultiblockParts.init();
        GTMultiblocks.init();
        GTSingleblocks.init();
    }
}
