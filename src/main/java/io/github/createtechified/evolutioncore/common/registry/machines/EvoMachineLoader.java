package io.github.createtechified.evolutioncore.common.registry.machines;

import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.EvoTabs;
import io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.PrimitiveMultiblocks;
import io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.SteamMultiblocksHP;
import io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.SteamMultiblocksLP;

public class EvoMachineLoader {
    static {
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MAIN);
    }

    public static void init() {
        EvoMultiParts.init();
        EvoSingleblocks.init();
        PrimitiveMultiblocks.init();
        SteamMultiblocksLP.init();
        SteamMultiblocksHP.init();
    }
}
