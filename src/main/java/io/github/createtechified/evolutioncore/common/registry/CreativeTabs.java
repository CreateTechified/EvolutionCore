package io.github.createtechified.evolutioncore.common.registry;

import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MODID);
    public static final RegistryObject<CreativeModeTab> EVOLUTIONCORE_MAIN = CREATIVE_TABS.register("main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.evolutioncore.main"))
            .icon(() -> ModMachines.STEAM_VACUUM_PUMP.first().asStack())
            .displayItems(((itemDisplayParameters, output) -> {
                ModItems.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
                output.accept(ModMachines.STEAM_VACUUM_PUMP.first().asStack());
                output.accept(ModMachines.STEAM_VACUUM_PUMP.second().asStack());
            }))
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
