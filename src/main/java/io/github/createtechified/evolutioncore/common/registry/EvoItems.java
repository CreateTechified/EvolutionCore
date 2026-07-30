package io.github.createtechified.evolutioncore.common.registry;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.entry.ItemEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.tools.HealingAxe;
import io.github.createtechified.evolutioncore.common.tools.HammerItem;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;

import static io.github.createtechified.evolutioncore.common.registry.utils.ItemConstructors.*;
import static io.github.createtechified.evolutioncore.common.registry.utils.GTItemConstructors.*;

@SuppressWarnings("unused")
public class EvoItems {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> EvoTabs.EVOLUTIONCORE_MAIN);
    }

    // Misc Items
    public static ItemEntry<Item> PLANT_FIBER = constructBasicItem("plant_fiber", EvolutionCoreMod.id("item/early/plant_fiber"));
    public static ItemEntry<Item> FLINT_SHARD = constructBasicItem("flint_shard", EvolutionCoreMod.id("item/early/flint_shard"));
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
    public static ItemEntry<AxeItem> FLINT_HATCHET = constructHandheldItem("flint_hatchet", EvolutionCoreMod.id("item/tools/flint_hatchet"),
            p -> new AxeItem(Tiers.WOOD, 3, -3.2f, p),
            b -> b.recipe((ctx, prov) -> ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ctx.get())
                            .pattern("PF")
                            .pattern("SP")
                            .define('S', Items.STICK)
                            .define('P', EvoItems.PLANT_FIBER)
                            .define('F', EvoItems.FLINT_SHARD)
                            .unlockedBy("has_flint", RegistrateRecipeProvider.has(Items.FLINT))
                            .save(prov)));
    public static ItemEntry<HammerItem> FLINT_HAMMER = constructHandheldItem("flint_hammer", EvolutionCoreMod.id("item/tools/flint_hammer"),
            p -> new HammerItem(3, -3.2f, Tiers.WOOD, p), b -> {});
    public static ItemEntry<HealingAxe> HEALING_AXE = constructHandheldItem("healing_axe", EvolutionCoreMod.id("item/tools/healing_axe"),
            p -> new HealingAxe(Tiers.DIAMOND, 1, -3, p), b -> {});
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
}