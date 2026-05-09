package io.github.createtechified.evolutioncore.common.registry.machines;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import io.github.createtechified.evolutioncore.Reference;

@SuppressWarnings("unused")
public class ModMachines {
    public static void init() {
        Reference.REGISTRATE.creativeModeTab(GTCreativeModeTabs.MACHINE);
        GTPrimitiveMultiblocks.init();
        GTSteamSingleblocks.init();
    }
}
