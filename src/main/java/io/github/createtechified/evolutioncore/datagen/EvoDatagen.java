package io.github.createtechified.evolutioncore.datagen;

import com.tterrag.registrate.providers.ProviderType;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.datagen.providers.ItemTagHandler;
import io.github.createtechified.evolutioncore.datagen.providers.LanguageHandler;
import io.github.createtechified.evolutioncore.datagen.providers.recipe.SequencedAssemblyProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EvoDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator gen = e.getGenerator();
        PackOutput out = gen.getPackOutput();
        Reference.REGISTRATE.addDataGenerator(ProviderType.LANG, LanguageHandler::init);
        Reference.REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, ItemTagHandler::init);

        if (e.includeServer()) {
            gen.addProvider(true, new SequencedAssemblyProvider(out));
        }
    }
}
