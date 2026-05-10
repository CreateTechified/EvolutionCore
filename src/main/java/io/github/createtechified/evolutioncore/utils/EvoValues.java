package io.github.createtechified.evolutioncore.utils;

import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

@SuppressWarnings({"unused", "unchecked"})
public class EvoValues {
    public static final TagKey<Item>[] CIRCUIT_TAGS = new TagKey[] {
            CustomTags.ULV_CIRCUITS,
            CustomTags.LV_CIRCUITS,
            CustomTags.MV_CIRCUITS,
            CustomTags.HV_CIRCUITS,
            CustomTags.EV_CIRCUITS,
            CustomTags.IV_CIRCUITS,
            CustomTags.LuV_CIRCUITS,
            CustomTags.ZPM_CIRCUITS,
            CustomTags.UV_CIRCUITS,
            CustomTags.UHV_CIRCUITS,
            CustomTags.UEV_CIRCUITS,
            CustomTags.UIV_CIRCUITS,
            CustomTags.UXV_CIRCUITS,
            CustomTags.OpV_CIRCUITS,
            CustomTags.MAX_CIRCUITS
    };
}
