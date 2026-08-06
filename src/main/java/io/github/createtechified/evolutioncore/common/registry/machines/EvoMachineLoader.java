package io.github.createtechified.evolutioncore.common.registry.machines;

import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.EvoCoilBlocks;
import io.github.createtechified.evolutioncore.common.registry.EvoModifications;
import io.github.createtechified.evolutioncore.common.registry.EvoTabs;
import io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.PrimitiveMultiblocks;
import io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.SteamMultiblocksHP;
import io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.SteamMultiblocksLP;
import io.github.createtechified.evolutioncore.common.registry.machines.multiblocks.electric.*;

public class EvoMachineLoader {
    public static void init() {
        EvoModifications.machines();
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MACHINES);
        EvoCoilBlocks.init();
        EvoMultiParts.init();
        EvoSingleblocks.init();
        PrimitiveMultiblocks.init();
        SteamMultiblocksLP.init();
        SteamMultiblocksHP.init();
        OreProcessingMultiblocks.init();
        GeneratorMultiblocks.init();
        ResourceGenerationMultiblocks.init();
        FusionMultiblocks.init();
        UpgradeMultiblocks.init();
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MATERIALS);
    }
}