package io.github.createtechified.evolutioncore.datagen.providers;

import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {
    public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Reference.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ModItems.ITEMS.getEntries().forEach(entry -> {
            Item item = entry.get();
            if (!(item instanceof BlockItem)) {
                boolean exists = existingFileHelper.exists(modLoc("item/" + item), PackType.CLIENT_RESOURCES, ".png", "textures");
                if (exists) basicItem(item);
                else System.out.println("Skipping item model for " + item + " - Texture missing");
            }
        });
    }
}
