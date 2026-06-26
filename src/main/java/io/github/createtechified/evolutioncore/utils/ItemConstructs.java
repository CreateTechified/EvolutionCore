package io.github.createtechified.evolutioncore.utils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.common.data.GTCovers;
import com.gregtechceu.gtceu.common.item.CoverPlaceBehavior;
import com.gregtechceu.gtceu.common.item.TooltipBehavior;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;

import static io.github.createtechified.evolutioncore.Reference.CIRCUIT_TAGS;

@SuppressWarnings("unused")
public class ItemConstructs {
    public static <T extends Item> ItemEntry<T> constructItem(String name, NonNullFunction<Item.Properties, T> factory, Consumer<ItemBuilder<T, ?>> customizer) {
        return Reference.REGISTRATE.item(name, factory).transform(b -> {
            customizer.accept(b);
            return b;
        }).register();
    }

    public static <T extends Item> ItemEntry<T> constructItem(String name, NonNullFunction<Item.Properties, T> factory) {
        return constructItem(name, factory, b -> {
        });
    }

    public static ItemEntry<Item> constructUniversalCircuit(int tier) {
        String name = "universal_circuit_" + GTValues.VN[tier].toLowerCase();
        return constructItem(name, Item::new,
                b -> b.lang("%s Universal Circuit".formatted(GTValues.VNF[tier])).tag(CIRCUIT_TAGS[tier]));
    }

    public static ItemEntry<Item> constructBasicItem(String name) {
        return constructItem(name, Item::new);
    }
    public static ItemEntry<Item> constructBasicItem(String name, String lang) {
        return constructItem(name, Item::new, b -> b.lang(lang));
    }

    public static ItemEntry<Item> constructElectricMotor(int tier) {
        String name = GTValues.VN[tier].toLowerCase() + "_electric_motor";
        return constructItem(name, Item::new,
                b -> b.lang("%s Electric Motor".formatted(GTValues.VN[tier])).tag(CustomTags.ELECTRIC_MOTORS));
    }

    public static ItemEntry<ComponentItem> constructElectricPump(int tier, int transferRate) {
        String name = GTValues.VN[tier].toLowerCase() + "_electric_pump";
        return constructItem(name, ComponentItem::create,
                b -> b.lang("%s Electric Pump".formatted(GTValues.VN[tier]))
                        .onRegister(item -> item.attachComponents(new CoverPlaceBehavior(GTCovers.PUMPS[tier])))
                        .onRegister(item -> item.attachComponents(new TooltipBehavior(lines -> {
                            lines.add(Component.translatable("item.gtceu.electric.pump.tooltip"));
                            lines.add(Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate", transferRate));
                        })))
                        .tag(CustomTags.ELECTRIC_PUMPS));
    }
    public static ItemEntry<Item> constructElectricPump(int tier) {
        String name = GTValues.VN[tier].toLowerCase() + "_electric_pump";
        return constructItem(name, Item::new,
                b -> b.lang("%s Electric Pump".formatted(GTValues.VN[tier])).tag(CustomTags.ELECTRIC_PUMPS));
    }

    public static ItemEntry<ComponentItem> constructFluidRegulator(int tier, int transferRate) {
        String name = GTValues.VN[tier].toLowerCase() + "_fluid_regulator";
        return constructItem(name, ComponentItem::create,
                b -> b.lang("%s Fluid Regulator".formatted(GTValues.VN[tier]))
                        .onRegister(item -> item.attachComponents(new CoverPlaceBehavior(GTCovers.FLUID_REGULATORS[tier])))
                        .onRegister(item -> item.attachComponents(new TooltipBehavior(lines -> {
                            lines.add(Component.translatable("item.gtceu.fluid.regulator.tooltip"));
                            lines.add(Component.translatable("gtceu.universal.tooltip.fluid_transfer_rate", transferRate));
                        })))
                        .tag(CustomTags.FLUID_REGULATORS));
    }
    public static ItemEntry<Item> constructFluidRegulator(int tier) {
        String name = GTValues.VN[tier].toLowerCase() + "_fluid_regulator";
        return constructItem(name, Item::new,
                b -> b.lang("%s Fluid Regulator".formatted(GTValues.VN[tier])).tag(CustomTags.FLUID_REGULATORS));
    }

    public static ItemEntry<ComponentItem> constructConveyorModule(int tier, int transferRate) {
        String name = GTValues.VN[tier].toLowerCase() + "_conveyor_module";
        return constructItem(name, ComponentItem::create,
                b -> b.lang("%s Conveyor Module".formatted(GTValues.VN[tier]))
                        .onRegister(item -> item.attachComponents(new CoverPlaceBehavior(GTCovers.CONVEYORS[tier])))
                        .onRegister(item -> item.attachComponents(new TooltipBehavior(lines -> {
                            lines.add(Component.translatable("item.gtceu.conveyor.module.tooltip"));
                            if (tier >= 3) { // Over HV, use stacks.
                                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", transferRate));
                            } else {
                                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate", transferRate));
                            }
                        })))
                        .tag(CustomTags.CONVEYOR_MODULES));
    }
    public static ItemEntry<Item> constructConveyorModule(int tier) {
        String name = GTValues.VN[tier].toLowerCase() + "_conveyor_module";
        return constructItem(name, Item::new,
                b -> b.lang("%s Conveyor Module".formatted(GTValues.VN[tier])).tag(CustomTags.CONVEYOR_MODULES));
    }

    public static ItemEntry<Item> constructElectricPiston(int tier) {
        String name = GTValues.VN[tier].toLowerCase() + "_electric_piston";
        return constructItem(name, Item::new,
                b -> b.lang("%s Electric Piston".formatted(GTValues.VN[tier])).tag(CustomTags.ELECTRIC_MOTORS));
    }

    public static ItemEntry<ComponentItem> constructRobotArm(int tier, int transferRate) {
        String name = GTValues.VN[tier].toLowerCase() + "_robot_arm";
        return constructItem(name, ComponentItem::create,
                b -> b.lang("%s Robot Arm".formatted(GTValues.VN[tier]))
                        .onRegister(item -> item.attachComponents(new CoverPlaceBehavior(GTCovers.ROBOT_ARMS[tier])))
                        .onRegister(item -> item.attachComponents(new TooltipBehavior(lines -> {
                            lines.add(Component.translatable("item.gtceu.robot.arm.tooltip"));
                            if (tier >= 3) { // Over HV, use stacks.
                                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate_stacks", transferRate));
                            } else {
                                lines.add(Component.translatable("gtceu.universal.tooltip.item_transfer_rate", transferRate));
                            }
                        })))
                        .tag(CustomTags.ROBOT_ARMS));
    }
    public static ItemEntry<Item> constructRobotArm(int tier) {
        String name = GTValues.VN[tier].toLowerCase() + "_robot_arm";
        return constructItem(name, Item::new,
                b -> b.lang("%s Robot Arm".formatted(GTValues.VN[tier])).tag(CustomTags.ROBOT_ARMS));
    }

    public static ItemEntry<Item> constructFieldGenerator(int tier) {
        String name = GTValues.VN[tier].toLowerCase() + "_field_generator";
        return constructItem(name, Item::new,
                b -> b.lang("%s Field Generator".formatted(GTValues.VN[tier])).tag(CustomTags.FIELD_GENERATORS));
    }

    public static ItemEntry<Item> constructEmitter(int tier) {
        String name = GTValues.VN[tier].toLowerCase() + "_emitter";
        return constructItem(name, Item::new,
                b -> b.lang("%s Emitter".formatted(GTValues.VN[tier])).tag(CustomTags.EMITTERS));
    }

    public static ItemEntry<Item> constructSensor(int tier) {
        String name = GTValues.VN[tier].toLowerCase() + "_sensor";
        return constructItem(name, Item::new,
                b -> b.lang("%s Sensor".formatted(GTValues.VN[tier])).tag(CustomTags.SENSORS));
    }
}
