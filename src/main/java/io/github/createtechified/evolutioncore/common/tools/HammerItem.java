package io.github.createtechified.evolutioncore.common.tools;

import io.github.createtechified.evolutioncore.common.registry.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;

public class HammerItem extends DiggerItem {
    public HammerItem(float attackDamageModifier, float attackSpeedModifier, Tier tier, Properties properties) {
        super(attackDamageModifier, attackSpeedModifier, tier, ModTags.Blocks.MINEABLE_WITH_HAMMER, properties);
    }
}
