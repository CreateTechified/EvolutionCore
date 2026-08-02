package io.github.createtechified.evolutioncore.common.overhaul;

import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

// That tends to hurt...
@EventBusSubscriber(modid = Reference.MODID)
public class DontPunchBlocks {

    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        if (event.getState().isEmpty() || event.getEntity() == null) return;

        BlockState state = event.getState();
        ItemStack heldItem = event.getEntity().getMainHandItem();

        if (state.is(BlockTags.LOGS)) {
            if (!heldItem.canPerformAction(ItemAbilities.AXE_DIG)) {
                event.setCanceled(true);
                return;
            }
        }

        if (state.is(Tags.Blocks.STONES)) {
            if (!heldItem.canPerformAction(ItemAbilities.PICKAXE_DIG)) {
                event.setCanceled(true);
                return;
            }
        }

        if (state.is(BlockTags.PLANKS)) {
            event.setNewSpeed(event.getOriginalSpeed() / 2.0f);
        }
    }
}
