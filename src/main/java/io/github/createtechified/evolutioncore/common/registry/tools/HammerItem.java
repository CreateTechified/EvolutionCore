package io.github.createtechified.evolutioncore.common.registry.tools;

import io.github.createtechified.evolutioncore.common.registry.EvoTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;

public class HammerItem extends DiggerItem {
    public HammerItem(Tier tier, Properties properties) {
        super(tier, EvoTags.Blocks.MINEABLE_WITH_HAMMER, properties);
    }
}
