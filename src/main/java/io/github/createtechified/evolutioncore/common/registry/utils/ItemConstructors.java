package io.github.createtechified.evolutioncore.common.registry.utils;

import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;

public class ItemConstructors {
    public static <T extends Item> ItemEntry<T> constructItem(String name, ResourceLocation texture, NonNullFunction<Item.Properties, T> factory, Consumer<ItemBuilder<T, ?>> customizer) {
        return Reference.REGISTRATE.item(name, factory).transform(b -> {
            customizer.accept(b);
            return b;
        }).model((ctx, prov) -> prov.generated(ctx, texture)).register();
    }
    public static <T extends Item> ItemEntry<T> constructHandheldItem(String name, ResourceLocation texture, NonNullFunction<Item.Properties, T> factory, Consumer<ItemBuilder<T, ?>> customizer) {
        return Reference.REGISTRATE.item(name, factory).transform(b -> {
            customizer.accept(b);
            return b;
        }).model((ctx, prov) -> prov.handheld(ctx, texture)).register();
    }

    public static <T extends Item> ItemEntry<T> constructItem(String name, ResourceLocation texture, NonNullFunction<Item.Properties, T> factory) {
        return constructItem(name, texture, factory, b -> {});
    }
    public static ItemEntry<Item> constructBasicItem(String name) {
        return constructItem(name, EvolutionCoreMod.id("item/" + name), Item::new);
    }
    public static ItemEntry<Item> constructBasicItem(String name, ResourceLocation texture) {
        return constructItem(name, texture, Item::new);
    }
    public static ItemEntry<Item> constructBasicItem(String name, ResourceLocation texture, String lang) {
        return constructItem(name, texture, Item::new, b -> b.lang(lang));
    }
}
