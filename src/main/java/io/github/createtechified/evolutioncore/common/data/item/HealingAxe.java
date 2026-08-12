package io.github.createtechified.evolutioncore.common.data.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
public class HealingAxe extends AxeItem {
    public HealingAxe(Tier tier, float attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(tier, attackDamageModifier, attackSpeedModifier, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean selected) {
        if (!selected || !(entity instanceof Player) || level.isClientSide) return;
        assert entity instanceof Player;
        ((Player) entity).getFoodData().eat(1, 0.2F);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (entity instanceof LivingEntity) {
            if (((LivingEntity) entity).getMobType() == MobType.UNDEAD) entity.hurt(player.level().damageSources().playerAttack(player), 4);
            else {
                ((LivingEntity) entity).heal(8);
                return true;
            }
        }
        return false;
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, Consumer<T> onBroken) {
        return 0;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return false;
    }
}
