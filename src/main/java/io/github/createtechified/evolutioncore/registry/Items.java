package io.github.createtechified.evolutioncore.registry;

import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.gregtechceu.gtceu.api.GTValues;

import java.util.Objects;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);

    public static void register(IEventBus eventBus) {
        for (int tier = GTValues.ULV; tier <= GTValues.MAX; tier++) {
            String tierName = GTValues.VN[tier].toLowerCase();
            int tierColor = GTValues.VCM[tier];
            registerTier(tierName, tierColor);
        }

        ITEMS.register(eventBus);
    }

    private static void registerTier(String tierName, int tierColor) {
        registerUniversalCircuit(tierName, tierColor, "mainframe");
    }

    private static void registerUniversalCircuit(String tierName, int tierColor, String circuitType) {
        String name = "universal_circuit_" + circuitType + "_" + tierName;
        ITEMS.register(name, () -> new Item(new Item.Properties()) {
            @Override
            public Component getName(ItemStack stack) {
                if (Objects.equals(tierName, "max")) return Component.translatable(this.getDescriptionId()).withStyle(style -> style.withColor(tierColor).withBold(true));
                if (Objects.equals(tierName, "opv")) return Component.translatable(this.getDescriptionId()).withStyle(style -> style.withColor(tierColor).withBold(true));
                else return Component.translatable(this.getDescriptionId()).withStyle(style -> style.withColor(tierColor));
            }
        });
    }
}
