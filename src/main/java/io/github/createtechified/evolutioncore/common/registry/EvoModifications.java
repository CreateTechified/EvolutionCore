package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.FluidPipeProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IngotProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.common.mui.GTGuiTheme;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class EvoModifications {
    public static void materials() {
        GTMaterials.NaquadahAlloy.setProperty(
                PropertyKey.FLUID_PIPE,
                new FluidPipeProperties(7200, 15780, true, true, false, false)
        );

        GTMaterials.Netherite.addFlags(
                MaterialFlags.GENERATE_PLATE,
                MaterialFlags.GENERATE_DENSE,
                MaterialFlags.GENERATE_ROD,
                MaterialFlags.GENERATE_LONG_ROD,
                MaterialFlags.GENERATE_BOLT_SCREW,
                MaterialFlags.GENERATE_FRAME,
                MaterialFlags.GENERATE_GEAR,
                MaterialFlags.GENERATE_SMALL_GEAR,
                MaterialFlags.GENERATE_FOIL,
                MaterialFlags.GENERATE_RING,
                MaterialFlags.GENERATE_ROTOR
        );

        GTMaterials.Polonium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Polonium.setMaterialARGB(0x00B389);
        GTMaterials.Polonium.addFlags(
                MaterialFlags.GENERATE_PLATE,
                MaterialFlags.GENERATE_ROD,
                MaterialFlags.GENERATE_LONG_ROD,
                MaterialFlags.GENERATE_FOIL
        );

        GTMaterials.Technetium.setProperty(PropertyKey.INGOT, new IngotProperty());
        GTMaterials.Technetium.setMaterialARGB(0x003461);
        GTMaterials.Technetium.addFlags(
                MaterialFlags.GENERATE_PLATE,
                MaterialFlags.GENERATE_ROD,
                MaterialFlags.GENERATE_LONG_ROD,
                MaterialFlags.GENERATE_BOLT_SCREW,
                MaterialFlags.GENERATE_GEAR,
                MaterialFlags.GENERATE_SMALL_GEAR,
                MaterialFlags.GENERATE_FOIL
        );

        GTMaterials.Netherite.setFormula("Nr");
        EvoMaterials.QuantumInfusion.setFormula("⚛");
    }
}