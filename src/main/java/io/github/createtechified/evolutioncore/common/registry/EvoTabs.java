package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.tterrag.registrate.util.entry.RegistryEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.machines.EvoCoilBlocks;
import io.github.createtechified.evolutioncore.common.registry.machines.EvoSingleblocks;
import net.minecraft.world.item.CreativeModeTab;

public class EvoTabs {
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> EVOLUTIONCORE_MAIN = Reference.REGISTRATE.defaultCreativeTab("main",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("main", Reference.REGISTRATE))
                            .icon(() -> EvoItems.HEALING_AXE.asStack())
                            .title(Reference.REGISTRATE.addLang("itemGroup", EvolutionCoreMod.id("main"), "EvolutionCore - Main"))
                            .withTabsBefore(GTCreativeModeTabs.MACHINE.getKey())
                            .build())
            .register();
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> EVOLUTIONCORE_BLOCKS = Reference.REGISTRATE.defaultCreativeTab("blocks",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("blocks", Reference.REGISTRATE))
                            .icon(() -> EvoCoilBlocks.NEURALIC_ALLOY_7_COIL.asStack())
                            .title(Reference.REGISTRATE.addLang("itemGroup", EvolutionCoreMod.id("blocks"), "EvolutionCore - Blocks"))
                            .withTabsBefore(EvoTabs.EVOLUTIONCORE_MAIN.getKey())
                            .build())
            .register();
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> EVOLUTIONCORE_MACHINES = Reference.REGISTRATE.defaultCreativeTab("machines",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("machines", Reference.REGISTRATE))
                            .icon(() -> EvoSingleblocks.STEAM_ASSEMBLER.left().asStack())
                            .title(Reference.REGISTRATE.addLang("itemGroup", EvolutionCoreMod.id("machines"), "EvolutionCore - Machines"))
                            .withTabsBefore(EvoTabs.EVOLUTIONCORE_BLOCKS.getKey())
                            .build())
            .register();
    public static final RegistryEntry<CreativeModeTab, CreativeModeTab> EVOLUTIONCORE_MATERIALS = Reference.REGISTRATE.defaultCreativeTab("materials",
                    builder -> builder.displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("materials", Reference.REGISTRATE))
                            .icon(() -> ChemicalHelper.get(TagPrefix.ingot, EvoMaterials.WrldappleAlloy))
                            .title(Reference.REGISTRATE.addLang("itemGroup", EvolutionCoreMod.id("materials"), "EvolutionCore - Materials"))
                            .withTabsBefore(EvoTabs.EVOLUTIONCORE_MACHINES.getKey())
                            .build())
            .register();

    public static void init() {
        // i cast exist
    }
}