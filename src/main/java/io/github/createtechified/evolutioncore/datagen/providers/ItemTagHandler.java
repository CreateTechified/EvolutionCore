package io.github.createtechified.evolutioncore.datagen.providers;

import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.tterrag.registrate.providers.RegistrateItemTagsProvider;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.EvoTags;

import java.util.function.Supplier;

public class ItemTagHandler {
    public static void init(RegistrateItemTagsProvider provider) {
        provider.addTag(EvoTags.Items.HIDDEN_FROM_RECIPE_VIEWERS).add(GTMultiMachines.STEAM_GRINDER.asItem());
        provider.addTag(EvoTags.Items.HIDDEN_FROM_RECIPE_VIEWERS).add(GTMultiMachines.STEAM_OVEN.asItem());
        provider.addTag(EvoTags.Items.HIDDEN_FROM_RECIPE_VIEWERS).add(GTMultiMachines.CHARCOAL_PILE_IGNITER.asItem());
    }
}
