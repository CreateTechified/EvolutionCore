package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.api.GTValues;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.tools.HammerItem;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.nbt.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;

import javax.swing.text.html.HTML;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class ModItems {
    public static void init() {
        // i cast exist
    }

    static {
        Reference.REGISTRATE.creativeModeTab(() -> CreativeTabs.EVOLUTIONCORE_MAIN);
    }

    public static <T extends Item> ItemEntry<T> constructItem(String name, NonNullFunction<Item.Properties, T> factory, Consumer<ItemBuilder<T, ?>> customizer) {
        return Reference.REGISTRATE.item(name, factory).transform(b -> { customizer.accept(b); return b; }).register();
    }
    public static <T extends Item> ItemEntry<T> constructItem(String name, NonNullFunction<Item.Properties, T> factory) {
        return constructItem(name, factory, b -> {});
    }

    public static ItemEntry<Item> constructUniversalCircuit(String name, int tier) {
        return constructItem(name, Item::new,
                b -> b.lang("%s Universal Circuit".formatted(GTValues.VNF[tier])).tag(Reference.CIRCUIT_TAGS[tier]));
    }

    public static ItemEntry<Item> constructBasicItem(String name) {
        return constructItem(name, Item::new);
    }

    // Misc Items
    public static ItemEntry<Item> PLANT_FIBER = constructBasicItem("plant_fiber");
    public static ItemEntry<Item> FLINT_SHARD = constructBasicItem("flint_shard");
    // Vacuum Tube Parts (ULV/Steam)
    public static ItemEntry<Item> CARBON_FILAMENT = constructBasicItem("carbon_filament");
    public static ItemEntry<Item> GRAPHITE_ELECTRODE = constructBasicItem("graphite_electrode");
    public static ItemEntry<Item> INCOMPLETE_VACUUM_TUBE_BASE = constructItem("incomplete_vacuum_tube_base", SequencedAssemblyItem::new);
    public static ItemEntry<Item> VACUUM_TUBE_BASE = constructBasicItem("vacuum_tube_base");
    public static ItemEntry<Item> INCOMPLETE_UNSEALED_VACUUM_TUBE = constructItem("incomplete_unsealed_vacuum_tube", SequencedAssemblyItem::new);
    public static ItemEntry<Item> UNSEALED_VACUUM_TUBE = constructBasicItem("unsealed_vacuum_tube");
    public static ItemEntry<Item> FAILED_VACUUM_TUBE_PARTS = constructBasicItem("failed_vacuum_tube_parts");
    // MAX Components
    public static ItemEntry<Item> MAX_ELECTRIC_MOTOR = constructBasicItem("max_electric_motor");
    public static ItemEntry<Item> MAX_ELECTRIC_PUMP = constructBasicItem("max_electric_pump");
    public static ItemEntry<Item> MAX_FLUID_REGULATOR = constructBasicItem("max_fluid_regulator");
    public static ItemEntry<Item> MAX_CONVEYOR_MODULE = constructBasicItem("max_conveyor_module");
    public static ItemEntry<Item> MAX_ELECTRIC_PISTON = constructBasicItem("max_electric_piston");
    public static ItemEntry<Item> MAX_ROBOT_ARM = constructBasicItem("max_robot_arm");
    public static ItemEntry<Item> MAX_FIELD_GENERATOR = constructBasicItem("max_field_generator");
    public static ItemEntry<Item> MAX_EMITTER = constructBasicItem("max_emitter");
    public static ItemEntry<Item> MAX_SENSOR = constructBasicItem("max_sensor");
    // Tools
    public static ItemEntry<AxeItem> FLINT_HATCHET = constructItem("flint_hatchet",
            p -> new AxeItem(ModToolTiers.FLINT, 3, -3.2f, p),
            b -> b.recipe((ctx, prov) -> ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ctx.get())
                    .pattern("PF")
                    .pattern("SP")
                    .define('S', Items.STICK)
                    .define('P', ModItems.PLANT_FIBER)
                    .define('F', ModItems.FLINT_SHARD)
                    .unlockedBy("has_flint", RegistrateRecipeProvider.has(Items.FLINT))
                    .save(prov)));
    public static ItemEntry<HammerItem> FLINT_HAMMER = constructItem("flint_hammer",
            p -> new HammerItem(3, -3.2f, ModToolTiers.FLINT, p));
    // Universal circuits (1-Mainframe)
    public static ItemEntry<Item> ULV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_ulv", 0);
    public static ItemEntry<Item> LV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_lv", 1);
    public static ItemEntry<Item> MV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_mv", 2);
    public static ItemEntry<Item> HV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_hv", 3);
    public static ItemEntry<Item> EV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_ev", 4);
    public static ItemEntry<Item> IV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_iv", 5);
    public static ItemEntry<Item> LUV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_luv", 6);
    public static ItemEntry<Item> ZPM_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_zpm", 7);
    public static ItemEntry<Item> UV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_uv", 8);
    public static ItemEntry<Item> UHV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_uhv", 9);
    public static ItemEntry<Item> UEV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_uev", 10);
    public static ItemEntry<Item> UIV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_uiv", 11);
    public static ItemEntry<Item> UXV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_uxv", 12);
    public static ItemEntry<Item> OPV_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_opv", 13);
    public static ItemEntry<Item> MAX_UNIVERSAL_1 = constructUniversalCircuit("universal_circuit_max", 14);
}
