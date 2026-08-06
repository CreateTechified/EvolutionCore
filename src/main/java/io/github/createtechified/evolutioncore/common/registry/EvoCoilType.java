package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.block.ICoilType;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

/**
 * EvolutionCore's own heating coil types, separate from GTCEuM's {@link com.gregtechceu.gtceu.common.block.CoilBlock.CoilType}.
 * Each entry here gets registered as its own {@link com.gregtechceu.gtceu.common.block.CoilBlock} and plugged
 * into {@link com.gregtechceu.gtceu.api.GTCEuAPI#HEATING_COILS} so it works in the Electric Blast Furnace,
 * Multi Smelter, Pyrolyse Oven, etc. like any vanilla GT coil.
 * <p>
 * Note: tier is set explicitly rather than derived from ordinal() so these coils slot into GT's existing
 * tier space (Cupronickel=0 ... Tritanium=7) correctly instead of restarting at 0.
 * Alright should be enough, hopefully it actually works the way intended
 */
public enum EvoCoilType implements StringRepresentable, ICoilType {
    NEURALIC_ALLOY_7("neuralic_alloy_7", 13499, 24, 12, 8, EvoMaterials.NeuralicAlloy7,
            EvolutionCoreMod.id("block/coils/neuralic_alloy_7/coil"));

    @NotNull
    private final String name;
    // electric blast furnace properties
    private final int coilTemperature;
    // multi smelter properties
    private final int level;
    private final int energyDiscount;
    private final int tier;
    @NotNull
    private final Material material;
    @NotNull
    private final ResourceLocation texture;

    EvoCoilType(String name, int coilTemperature, int level, int energyDiscount, int tier, Material material,
                ResourceLocation texture) {
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
    public Material getMaterial() {
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