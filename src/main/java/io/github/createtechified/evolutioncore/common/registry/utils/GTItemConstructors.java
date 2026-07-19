package io.github.createtechified.evolutioncore.common.registry.utils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.util.entry.ItemEntry;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class GTItemConstructors {
    public static ItemEntry<Item> constructUniversalCircuit(int tier) {
        String name = "universal_circuit_" + GTValues.VN[tier].toLowerCase();
        ResourceLocation texture = EvolutionCoreMod.id("item/circuits/" + GTValues.VN[tier].toLowerCase());
        return ItemConstructors.constructItem(name, texture, Item::new,
                b -> b.lang("%s Universal Circuit".formatted(GTValues.VNF[tier])).tag(Reference.CIRCUIT_TAGS[tier]));
    }

    public static ItemEntry<Item> constructCoverlessCover(int tier, String type, String lang, TagKey<Item> tag) {
        String name = GTValues.VN[tier].toLowerCase() + "_" + type;
        return ItemConstructors.constructItem(name, EvolutionCoreMod.id("item/covers/" + name), Item::new,
                b -> b.lang(lang.formatted(GTValues.VN[tier])).tag(tag));
    }

    public static ItemEntry<Item> constructElectricMotor(int tier) {
        return constructCoverlessCover(tier, "electric_motor", "%s Electric Motor", CustomTags.ELECTRIC_MOTORS);
    }

    public static ItemEntry<Item> constructElectricPump(int tier) {
        return constructCoverlessCover(tier, "electric_pump", "%s Electric Pump", CustomTags.ELECTRIC_PUMPS);
    }

    public static ItemEntry<Item> constructFluidRegulator(int tier) {
        return constructCoverlessCover(tier, "fluid_regulator", "%s Fluid Regulator", CustomTags.FLUID_REGULATORS);
    }

    public static ItemEntry<Item> constructConveyorModule(int tier) {
        return constructCoverlessCover(tier, "conveyor_module", "%s Conveyor Module", CustomTags.CONVEYOR_MODULES);
    }

    public static ItemEntry<Item> constructElectricPiston(int tier) {
        return constructCoverlessCover(tier, "electric_piston", "%s Electric Piston", CustomTags.ELECTRIC_PISTONS);
    }

    public static ItemEntry<Item> constructRobotArm(int tier) {
        return constructCoverlessCover(tier, "robot_arm", "%s Robot Arm", CustomTags.ROBOT_ARMS);
    }

    public static ItemEntry<Item> constructFieldGenerator(int tier) {
        return constructCoverlessCover(tier, "field_generator", "%s Field Generator", CustomTags.FIELD_GENERATORS);
    }

    public static ItemEntry<Item> constructEmitter(int tier) {
        return constructCoverlessCover(tier, "emitter", "%s Emitter", CustomTags.EMITTERS);
    }

    public static ItemEntry<Item> constructSensor(int tier) {
        return constructCoverlessCover(tier, "sensor", "%s Sensor", CustomTags.SENSORS);
    }
}
