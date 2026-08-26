package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.FluidPipeProperties;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.IngotProperty;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class EvoModifications {
    public static void machines() {
        for (Supplier<MultiblockMachineDefinition> s : Reference.MACHINES_TO_REMOVE) {
            MultiblockMachineDefinition m = s.get();
            m.setRenderXEIPreview(false);
            m.setRenderWorldPreview(false);
            m.setRecipeTypes(new GTRecipeType[]{EvoRecipeTypes.NULL});
        }
        GTMultiMachines.PRIMITIVE_BLAST_FURNACE.setRecipeTypes(new GTRecipeType[]{EvoRecipeTypes.PRIMITIVE_BLAST_FURNACE});
    }

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

    private static void ingot(String material, String itemId) {
        TagPrefix.ingot.setIgnored(GTMaterials.get(material), itemSupplier(itemId));
    }
    private static void block(String material, String itemId) {
        TagPrefix.block.setIgnored(GTMaterials.get(material), itemSupplier(itemId));
    }
    private static void nugget(String material, String itemId) {
        TagPrefix.nugget.setIgnored(GTMaterials.get(material), itemSupplier(itemId));
    }
    private static void dust(String material, String itemId) {
        TagPrefix.dust.setIgnored(GTMaterials.get(material), itemSupplier(itemId));
    }
    private static void gem(String material, String itemId) {
        TagPrefix.gem.setIgnored(GTMaterials.get(material), itemSupplier(itemId));
    }

    private static Supplier<Item> itemSupplier(String itemId) {
        ResourceLocation rl = ResourceLocation.parse(itemId); // e.g. "experienceobelisk:cognitive_amalgam"
        return () -> BuiltInRegistries.ITEM.get(rl);
    }
}