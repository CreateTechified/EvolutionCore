package io.github.createtechified.evolutioncore.registry;

import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MODID);
    public static final RegistryObject<CreativeModeTab> EVOLUTIONCORE_MAIN = CREATIVE_TABS.register("evolutioncore", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.evolutioncore.main"))
            .icon(() -> {
                return Items.ITEMS.getEntries().stream()
                        .map(RegistryObject::get)
                        .findFirst() // just use the first item
                        .map(ItemStack::new)
                        .orElse(new ItemStack(net.minecraft.world.item.Items.COPPER_INGOT)); // fallback
            })
            .displayItems(((itemDisplayParameters, output) -> {
                Items.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
            }))
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
