package io.github.createtechified.evolutioncore.common.data.item;

import io.github.createtechified.evolutioncore.common.registry.EvoTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;

public class HammerItem extends DiggerItem {
    public HammerItem(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
        super(attackDamageModifier, attackSpeedModifier, tier, EvoTags.Blocks.MINEABLE_WITH_HAMMER, properties);
    }
}
