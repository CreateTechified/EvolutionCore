package io.github.createtechified.evolutioncore.common.data.block;

import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.gregtechceu.gtceu.utils.GTUtil;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.common.registry.EvoMaterials;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EvoCoilBlock extends CoilBlock {
    public EvoCoilBlock(Properties properties, ICoilType coilType) {
        super(properties, coilType);
    }

    // Yes, I did do this entirely to change the tooltip. You ain't gonna do nothin' about it tho.
    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable BlockGetter level, @NotNull List<Component> tooltip,
                                @NotNull TooltipFlag flag) {
        int coilTier = coilType.getTier(); // am pro
        if (GTUtil.isShiftDown()) {
            tooltip.add(Component.translatable("block.gtceu.wire_coil.tooltip_heat", coilType.getCoilTemperature()));
            tooltip.add(Component.translatable("block.gtceu.wire_coil.tooltip_smelter"));
            tooltip.add(
                    Component.translatable("block.gtceu.wire_coil.tooltip_parallel_smelter", coilType.getLevel() * 32));
            tooltip.add(Component.translatable("block.gtceu.wire_coil.tooltip_energy_smelter",
                    Math.max(1, (4 * coilType.getLevel() * 32 / (8 * coilType.getEnergyDiscount())))));
            tooltip.add(Component.translatable("block.gtceu.wire_coil.tooltip_pyro"));
            tooltip.add(Component.translatable("block.gtceu.wire_coil.tooltip_speed_pyro",
                    coilTier == 0 ? 75 : 50 * (coilTier + 1)));
            tooltip.add(Component.translatable("block.gtceu.wire_coil.tooltip_cracking"));
            tooltip.add(Component.translatable("block.gtceu.wire_coil.tooltip_energy_cracking", 100 - 10 * coilTier));
        } else {
            tooltip.add(Component.translatable("block.gtceu.wire_coil.tooltip_extended_info"));
            if (0<=coilTier && coilTier<=7) {
                tooltip.add(Component.translatable("evolutioncore.tooltip.coils.texture_notice").withStyle(ChatFormatting.RED));
            } else { // i borked gtm i think so inform the end user :thumbsup:
                tooltip.add(Component.translatable("evolutioncore.tooltip.coils.texture_crash").withStyle(ChatFormatting.DARK_RED));
            }
        }
    }

    /**
     * EvolutionCore's own heating coil types, separate from GTCEuM's {@link com.gregtechceu.gtceu.common.block.CoilBlock.CoilType}.
     * Each entry here gets registered as its own {@link com.gregtechceu.gtceu.common.block.CoilBlock} and plugged
     * into {@link com.gregtechceu.gtceu.api.GTCEuAPI#HEATING_COILS} so it works in the Electric Blast Furnace,
     * Multi Smelter, Pyrolyse Oven, etc. like any vanilla GT coil.
     * <p>
     * Note: tier is set explicitly rather than derived from ordinal() so these coils slot into GT's existing
     * tier space (Cupronickel=0 ... Tritanium=7) correctly instead of restarting at 0.
     * Alright should be enough, hopefully it actually works the way intended.
     * <p>
     * Note pt2: Pine lied about the coilable multis working... they technically work but the GUIs don't. Damn you GT!
     */
    public enum CoilType implements StringRepresentable, ICoilType {
        NEURALIC_ALLOY_7("neuralic_alloy_7", 13500, 24, 12, 8, EvoMaterials.NeuralicAlloy7, EvolutionCoreMod.id("block/coils/neuralic_alloy_7/coil")),
        WRLDAPPLE_ALLOY("wrldapple_alloy", 25879, 48, 36, 15, EvoMaterials.WrldappleAlloy, EvolutionCoreMod.id("block/coils/wrldapple_alloy/coil"))
        ;

        @NotNull
        private final String name;
        // electric blast furnace properties
        private final int coilTemperature;
        // multi smelter properties
        private final int level;
        // cracker/pyro properties
        private final int energyDiscount;
        // tier num (ordered pls!)
        private final int tier;
        @NotNull
        private final Material material;
        @NotNull
        private final ResourceLocation texture;

        CoilType(@NotNull String name, int coilTemperature, int level, int energyDiscount, int tier, @NotNull Material material,
                    @NotNull ResourceLocation texture) {
            this.name = name;
            this.coilTemperature = coilTemperature;
            this.level = level;
            this.energyDiscount = energyDiscount;
            this.tier = tier;
            this.material = material;
            this.texture = texture;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }

        @Override
        public int getCoilTemperature() {
            return coilTemperature;
        }

        @Override
        public int getLevel() {
            return level;
        }

        @Override
        public int getEnergyDiscount() {
            return energyDiscount;
        }

        @Override
        public int getTier() {
            return tier;
        }

        @Override
        public @NotNull Material getMaterial() {
            return material;
        }

        @NotNull
        @Override
        public ResourceLocation getTexture() {
            return texture;
        }

        @NotNull
        @Override
        public String toString() {
            return getName();
        }

        @NotNull
        @Override
        public String getSerializedName() {
            return name;
        }
    }
}
