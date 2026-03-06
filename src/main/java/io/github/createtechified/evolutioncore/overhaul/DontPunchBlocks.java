package io.github.createtechified.evolutioncore.overhaul;

import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// That tends to hurt...
@Mod.EventBusSubscriber(modid = Reference.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DontPunchBlocks {
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        if (event.getState() == null || event.getEntity() == null) return;

        BlockState state = event.getState();
        ItemStack heldItem = event.getEntity().getMainHandItem();

        if (state.is(BlockTags.LOGS)) {
            if (!heldItem.canPerformAction(ToolActions.AXE_DIG)) {
                event.setCanceled(true);
                return;
            }
        }

        if (state.is(Tags.Blocks.STONE)) {
            if (!heldItem.canPerformAction(ToolActions.PICKAXE_DIG)) {
                event.setCanceled(true);
                return;
            }
        }

        if (state.is(BlockTags.PLANKS)) {
            event.setNewSpeed(event.getOriginalSpeed() / 2.0f);
        }
    }
}
