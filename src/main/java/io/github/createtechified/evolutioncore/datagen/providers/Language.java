package io.github.createtechified.evolutioncore.datagen.providers;

import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.ModItems;
import io.github.createtechified.evolutioncore.utils.LangUtils;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class Language extends LanguageProvider {
    public Language(PackOutput output, String locale) {
        super(output, Reference.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.evolutioncore.main", "EvolutionCore - Main");
        add("itemGroup.evolutioncore.gt", "EvolutionCore - GregTech");
        add("book.pjevo.qb", "Questbook Wiki");
        add("book.pjevo.qb.land", "Welcome to Project Evolution");
        add("block.evolutioncore.lp_steam_vacuum_pump", "Low Pressure Steam Vacuum Pump");
        add("block.evolutioncore.hp_steam_vacuum_pump", "High Pressure Steam Vacuum Pump");
        add("evo.vac.tier", "Vacuum Tier: %s");
        ModItems.ITEMS.getEntries().forEach(item -> {
            String id = item.getId().getPath();
            if (id.startsWith("universal_circuit_")) {
                add(item.get(), LangUtils.circuitName(id));
            } else if (id.endsWith("_debug")) {
                return;
            } else {
                add(item.get(), LangUtils.regularName(id));
            }
        });

    }
}
