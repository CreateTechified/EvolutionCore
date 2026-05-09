package io.github.createtechified.evolutioncore.datagen.providers;

import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LanguageHandler {
    public static void init(RegistrateLangProvider provider) {
        provider.add("book.pjevo.qb", "Questbook Wiki");
        provider.add("book.pjevo.qb.land", "Welcome to Project Evolution");
        provider.add("evolutioncore.tooltip.steam_assembler", "Assembling with Steam!");
        provider.add("evolutioncore.tooltip.vacuum_pump", "Vacuum Tier: %s");
    }
}