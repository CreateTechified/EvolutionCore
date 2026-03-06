package io.github.createtechified.evolutioncore.registry;

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

import java.util.Objects;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MODID);

    public static void register(IEventBus eventBus) {
        for (int tier = GTValues.ULV; tier <= GTValues.MAX; tier++) {
            String tierName = GTValues.VN[tier].toLowerCase();
            int tierColor = GTValues.VCM[tier];
            registerGTTier(tierName, tierColor);
        }
        for (Tier tier : ModToolTiers.TIERS) {
            registerToolTier(tier);
        }

        registerStaticItems();
        ITEMS.register(eventBus);
    }

    private static void registerGTTier(String tierName, int tierColor) {
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

    private static void registerToolTier(Tier tier) {
        String tierName = TierSortingRegistry.getName(tier).getPath();
        String name = tierName + "_pickaxe_dont_use";
        ITEMS.register(name, () -> new PickaxeItem(tier, 0, 0f, new Item.Properties()));
    }

    private static void registerStaticItems() {
        ITEMS.register("flint_hatchet", () -> new AxeItem(ModToolTiers.FLINT, 3, -3.2f, new Item.Properties()));
    }
}
