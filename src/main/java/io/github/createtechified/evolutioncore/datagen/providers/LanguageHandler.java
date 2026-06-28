package io.github.createtechified.evolutioncore.datagen.providers;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LanguageHandler {
    public static void init(RegistrateLangProvider provider) {
        provider.add("book.pjevo.qb", "Questbook Wiki");
        provider.add("book.pjevo.qb.land", "Welcome to Project Evolution");
        provider.add("evolutioncore.tooltip.steam_assembler", "Assembling with Steam!");
        provider.add("evolutioncore.tooltip.primitive_alloy_kiln", "Alloying with Fire(bricks)!");
        provider.add("evolutioncore.tooltip.steam_alloy_kiln.l", "Steam-charged Parallelized Alloying Machine");
        provider.add("evolutioncore.tooltip.steam_separator.h.apology", "I am genuinely sorry that I made you do this. Enjoy the parallels!");
        provider.add("modifier.evolutioncore.mathematical", "Mathematical!");
        provider.add("modifier.evolutioncore.modifiable", "Modifiable");
        provider.add("material.evolutioncore.unstable", "Unstable Induced");
        provider.add("material.evolutioncore.magical_wood", "Magical Wooden");
    }
}