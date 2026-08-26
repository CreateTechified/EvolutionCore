package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.world.item.CreativeModeTab;

public class EvoTabs {
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> EVOLUTIONCORE_MAIN = Reference.REGISTRATE.defaultCreativeTab("main",
                    builder -> builder
                            .icon(() -> EvoItems.FLINT_HATCHET.asStack())
                            .title(Reference.REGISTRATE.addLang("itemGroup", EvolutionCoreMod.id("main"), "EvolutionCore - Main"))
                            .withTabsAfter(GTCreativeModeTabs.MACHINE.getKey())
                            .build())
            .register();
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> EVOLUTIONCORE_MACHINES = Reference.REGISTRATE.defaultCreativeTab("machines",
                    builder -> builder
                            .icon(() -> EvoItems.FLINT_HATCHET.asStack())
                            .title(Reference.REGISTRATE.addLang("itemGroup", EvolutionCoreMod.id("machines"), "EvolutionCore - Machines"))
                            .withTabsAfter(GTCreativeModeTabs.MACHINE.getKey())
                            .build())
            .register();
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> EVOLUTIONCORE_MATERIALS = Reference.REGISTRATE.defaultCreativeTab("materials",
                    builder -> builder
                            .icon(() -> EvoItems.FLINT_HATCHET.asStack())
                            .title(Reference.REGISTRATE.addLang("itemGroup", EvolutionCoreMod.id("materials"), "EvolutionCore - Materials"))
                            .withTabsAfter(GTCreativeModeTabs.MACHINE.getKey())
                            .build())
            .register();
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> EVOLUTIONCORE_BLOCKS = Reference.REGISTRATE.defaultCreativeTab("blocks",
                    builder -> builder
                            .icon(() -> EvoItems.FLINT_HATCHET.asStack())
                            .title(Reference.REGISTRATE.addLang("itemGroup", EvolutionCoreMod.id("blocks"), "EvolutionCore - Blocks"))
                            .withTabsAfter(GTCreativeModeTabs.MACHINE.getKey())
                            .build())
            .register();

    public static void init() {
        // i cast exist
    }
}
