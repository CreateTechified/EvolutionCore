package io.github.createtechified.evolutioncore.common.registry;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.entry.ItemEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.common.data.item.HealingAxe;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.Unbreakable;

import static io.github.createtechified.evolutioncore.common.registry.utils.ItemConstructors.*;
import static io.github.createtechified.evolutioncore.common.registry.utils.GTItemConstructors.*;

@SuppressWarnings("unused")
public class EvoItems {
    public static void init() {}

    // Misc Items
    public static ItemEntry<Item> GPS_DEVICE = constructItem("gps_device", EvolutionCoreMod.id("item/tools/gps_device"), Item::new, b -> b.lang("GPS Device").properties(p -> p.stacksTo(1)));
    // Vacuum Tube Parts (ULV/Steam)
    public static ItemEntry<Item> CARBON_FILAMENT = constructBasicItem("carbon_filament", EvolutionCoreMod.id("item/vactube/carbon_filament"));
    public static ItemEntry<Item> GRAPHITE_ELECTRODE = constructBasicItem("graphite_electrode", EvolutionCoreMod.id("item/vactube/graphite_electrode"));
    public static ItemEntry<Item> INCOMPLETE_VACUUM_TUBE_BASE = constructItem("incomplete_vacuum_tube_base", EvolutionCoreMod.id("item/vactube/incomplete_base"), SequencedAssemblyItem::new);
    public static ItemEntry<Item> VACUUM_TUBE_BASE = constructBasicItem("vacuum_tube_base", EvolutionCoreMod.id("item/vactube/base"));
    public static ItemEntry<Item> INCOMPLETE_UNSEALED_VACUUM_TUBE = constructItem("incomplete_unsealed_vacuum_tube", EvolutionCoreMod.id("item/vactube/incomplete_unsealed"), SequencedAssemblyItem::new);
    public static ItemEntry<Item> UNSEALED_VACUUM_TUBE = constructBasicItem("unsealed_vacuum_tube", EvolutionCoreMod.id("item/vactube/unsealed"));
    public static ItemEntry<Item> FAILED_VACUUM_TUBE_PARTS = constructBasicItem("failed_vacuum_tube_parts", EvolutionCoreMod.id("item/vactube/failed"));
    // MAX Components
    public static ItemEntry<Item> MAX_ELECTRIC_MOTOR = constructElectricMotor(14);
    public static ItemEntry<Item> MAX_ELECTRIC_PUMP = constructElectricPump(14);
    public static ItemEntry<Item> MAX_FLUID_REGULATOR = constructFluidRegulator(14);
    public static ItemEntry<Item> MAX_CONVEYOR_MODULE = constructConveyorModule(14);
    public static ItemEntry<Item> MAX_ELECTRIC_PISTON = constructElectricPiston(14);
    public static ItemEntry<Item> MAX_ROBOT_ARM = constructRobotArm(14);
    public static ItemEntry<Item> MAX_FIELD_GENERATOR = constructFieldGenerator(14);
    public static ItemEntry<Item> MAX_EMITTER = constructEmitter(14);
    public static ItemEntry<Item> MAX_SENSOR = constructSensor(14);
    // Tools
    public static ItemEntry<HealingAxe> HEALING_AXE = constructHandheldItem("healing_axe", EvolutionCoreMod.id("item/tools/healing_axe"),
            p -> new HealingAxe(Tiers.DIAMOND, p.component(DataComponents.UNBREAKABLE, new Unbreakable(true))), b -> {});
    // Universal circuits
    public static ItemEntry<Item> ULV_UNIVERSAL_1 = constructUniversalCircuit(0);
    public static ItemEntry<Item> LV_UNIVERSAL_1 = constructUniversalCircuit(1);
    public static ItemEntry<Item> MV_UNIVERSAL_1 = constructUniversalCircuit(2);
    public static ItemEntry<Item> HV_UNIVERSAL_1 = constructUniversalCircuit(3);
    public static ItemEntry<Item> EV_UNIVERSAL_1 = constructUniversalCircuit(4);
    public static ItemEntry<Item> IV_UNIVERSAL_1 = constructUniversalCircuit(5);
    public static ItemEntry<Item> LUV_UNIVERSAL_1 = constructUniversalCircuit(6);
    public static ItemEntry<Item> ZPM_UNIVERSAL_1 = constructUniversalCircuit(7);
    public static ItemEntry<Item> UV_UNIVERSAL_1 = constructUniversalCircuit(8);
    public static ItemEntry<Item> UHV_UNIVERSAL_1 = constructUniversalCircuit(9);
    public static ItemEntry<Item> UEV_UNIVERSAL_1 = constructUniversalCircuit(10);
    public static ItemEntry<Item> UIV_UNIVERSAL_1 = constructUniversalCircuit(11);
    public static ItemEntry<Item> UXV_UNIVERSAL_1 = constructUniversalCircuit(12);
    public static ItemEntry<Item> OPV_UNIVERSAL_1 = constructUniversalCircuit(13);
    public static ItemEntry<Item> MAX_UNIVERSAL_1 = constructUniversalCircuit(14);
    public static ItemEntry<Item> THORIUM_FUEL_ROD = constructFuelRod("thorium");
    public static ItemEntry<Item> URANIUM_238_FUEL_ROD = constructFuelRod("uranium_238");
    public static ItemEntry<Item> URANIUM_235_FUEL_ROD = constructFuelRod("uranium_235");
    public static ItemEntry<Item> PLUTONIUM_FUEL_ROD = constructFuelRod("plutonium");
    public static ItemEntry<Item> DEPLETED_THORIUM_FUEL_ROD = constructDepletedFuelRod("thorium");
    public static ItemEntry<Item> DEPLETED_URANIUM_238_FUEL_ROD = constructDepletedFuelRod("uranium_238");
    public static ItemEntry<Item> DEPLETED_URANIUM_235_FUEL_ROD = constructDepletedFuelRod("uranium_235");
    public static ItemEntry<Item> DEPLETED_PLUTONIUM_FUEL_ROD = constructDepletedFuelRod("plutonium");
}