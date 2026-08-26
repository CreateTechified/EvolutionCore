package io.github.createtechified.evolutioncore.datagen.providers;

import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.tterrag.registrate.providers.RegistrateItemTagsProvider;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.EvoTags;

import java.util.function.Supplier;

public class ItemTagHandler {
    public static void init(RegistrateItemTagsProvider provider) {
        for (Supplier<MultiblockMachineDefinition> s : Reference.MACHINES_TO_REMOVE) {
            MultiblockMachineDefinition m = s.get();
            provider.addTag(EvoTags.Items.HIDDEN_FROM_RECIPE_VIEWERS).add(m.getItem());
        }
    }
}
