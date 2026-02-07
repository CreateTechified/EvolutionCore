package io.github.createtechified.evolutioncore.datagen.providers;

import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.registry.Items;
import io.github.createtechified.evolutioncore.utils.LangUtils;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class Language extends LanguageProvider {
    public Language(PackOutput output, String locale) {
        super(output, Reference.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.evolutioncore.main", "Project Evolution Core");
        Items.ITEMS.getEntries().forEach(item -> {
            String id = item.getId().getPath();
            if (id.startsWith("universal_circuit_")) {
                add(item.get(), LangUtils.circuitName(id));
            }
        });
    }
}
