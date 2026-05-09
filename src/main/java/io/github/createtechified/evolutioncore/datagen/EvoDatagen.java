package io.github.createtechified.evolutioncore.datagen;

import com.tterrag.registrate.providers.ProviderType;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.datagen.providers.LanguageHandler;

public class EvoDatagen {
    public static void init() {
        Reference.REGISTRATE.addDataGenerator(ProviderType.LANG, LanguageHandler::init);
    }
}
