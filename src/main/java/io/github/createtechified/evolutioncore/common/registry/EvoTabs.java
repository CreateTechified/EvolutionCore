package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.world.item.CreativeModeTab;

public class EvoTabs {
    public static void init() {
        // i cast exist
    }

    public static final RegistryEntry<CreativeModeTab> EVOLUTIONCORE_MAIN = Reference.REGISTRATE.defaultCreativeTab("main",
            builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("main", Reference.REGISTRATE))
                    .icon(() -> EvoItems.FLINT_HATCHET.asStack())
                    .title(Reference.REGISTRATE.addLang("itemGroup", EvolutionCoreMod.id("main"), "EvolutionCore - Main"))
                    .build())
            .register();
}
