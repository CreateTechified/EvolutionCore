package io.github.createtechified.evolutioncore.common.registry;

import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.gregtechceu.gtceu.api.GTValues;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);
    public static final Map<String, RegistryObject<Item>> ITEM_MAP = new HashMap<>();

    public static void register(IEventBus eventBus) {
        for (int tier = GTValues.ULV; tier <= GTValues.MAX; tier++) {
            String tierName = GTValues.VN[tier].toLowerCase();
            int tierColor = GTValues.VCM[tier];
            registerGTTier(tierName, tierColor);
        }
        for (Tier tier : ModToolTiers.TIERS) {
            registerDebugForToolTier(tier);
        }

        registerStaticItems();
        ITEMS.register(eventBus);
    }

    public static Item getItem(String name) {
        return ITEM_MAP.get(name).get();
    }

    private static void registerGTTier(String tierName, int tierColor) {
        registerUniversalCircuit(tierName, tierColor, "mainframe");
    }

    private static void registerUniversalCircuit(String tierName, int tierColor, String circuitType) {
        String name = "universal_circuit_" + circuitType + "_" + tierName;
        ITEM_MAP.put(name, ITEMS.register(name, () -> new Item(new Item.Properties()) {
            @Override
            public Component getName(ItemStack stack) {
                if (Objects.equals(tierName, "max")) return Component.translatable(this.getDescriptionId()).withStyle(style -> style.withColor(tierColor).withBold(true));
                if (Objects.equals(tierName, "opv")) return Component.translatable(this.getDescriptionId()).withStyle(style -> style.withColor(tierColor).withBold(true));
                else return Component.translatable(this.getDescriptionId()).withStyle(style -> style.withColor(tierColor));
            }
        }));
    }

    private static void registerDebugForToolTier(Tier tier) {
        String tierName = TierSortingRegistry.getName(tier).getPath();
        String name = tierName + "_pickaxe_debug";
        ITEM_MAP.put(name, ITEMS.register(name, () -> new PickaxeItem(tier, 0, 0f, new Item.Properties())));
    }

    private static void constructBasicItem(String name) {
        ITEM_MAP.put(name, ITEMS.register(name, () -> new Item(new Item.Properties())));
    }

    private static void registerStaticItems() {
        ITEM_MAP.put("flint_hatchet", ITEMS.register("flint_hatchet", () -> new AxeItem(ModToolTiers.FLINT, 3, -3.2f, new Item.Properties())));
        constructBasicItem("plant_fiber");
        constructBasicItem("flint_shard");
    }
}
