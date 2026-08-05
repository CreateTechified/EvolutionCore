package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.machines.EvoSingleblocks;
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
    public static final RegistryEntry<CreativeModeTab> EVOLUTIONCORE_MACHINES = Reference.REGISTRATE.defaultCreativeTab("machines",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("machines", Reference.REGISTRATE))
                            .icon(() -> EvoSingleblocks.STEAM_ASSEMBLER.right().asStack())
                            .title(Reference.REGISTRATE.addLang("itemGroup", EvolutionCoreMod.id("machines"), "EvolutionCore - Machines"))
                            .build())
            .register();
    public static final RegistryEntry<CreativeModeTab> EVOLUTIONCORE_MATERIALS = Reference.REGISTRATE.defaultCreativeTab("materials",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("materials", Reference.REGISTRATE))
                            .icon(() -> ChemicalHelper.get(TagPrefix.ingot, EvoMaterials.WrldappleAlloy))
                            .title(Reference.REGISTRATE.addLang("itemGroup", EvolutionCoreMod.id("materials"), "EvolutionCore - Materials"))
                            .build())
            .register();
}
