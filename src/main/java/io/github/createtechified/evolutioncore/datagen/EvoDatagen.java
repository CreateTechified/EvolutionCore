package io.github.createtechified.evolutioncore.datagen;

import com.tterrag.registrate.providers.ProviderType;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.datagen.providers.ItemTagHandler;
import io.github.createtechified.evolutioncore.datagen.providers.LanguageHandler;
import io.github.createtechified.evolutioncore.datagen.providers.recipe.SequencedAssemblyProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber()
public class EvoDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator gen = e.getGenerator();
        PackOutput out = gen.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = e.getLookupProvider();

        if (e.includeServer()) {
            gen.addProvider(true, new SequencedAssemblyProvider(out, lookupProvider));
        }
    }

    public static void registrateDatagen() {
        Reference.REGISTRATE.addDataGenerator(ProviderType.LANG, LanguageHandler::init);
        Reference.REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, ItemTagHandler::init);
    }
}
