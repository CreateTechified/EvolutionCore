package io.github.createtechified.evolutioncore.registry;

import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.gregtechceu.gtceu.api.GTValues;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);

    public static void register(IEventBus eventBus) {
        for (int tier = GTValues.ULV; tier <= GTValues.UHV; tier++) {
            String tierName = GTValues.VN[tier].toLowerCase();
            registerTier(tierName);
        }

        ITEMS.register(eventBus);
    }

    private static void registerTier(String tierName) {
        registerUniversalCircuit(tierName, "mainframe");
    }

    private static void registerUniversalCircuit(String tierName, String circuitType) {
        String name = "universal_circuit_" + circuitType + "_" + tierName;
        ITEMS.register(name, () -> new Item(new Item.Properties()));
    }
}
