package io.github.createtechified.evolutioncore.utils;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.block.property.GTBlockStateProperties;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.model.generators.ModelFile;

import java.util.function.Consumer;

@SuppressWarnings({"unused", "removal"})
public class EvoConstructs {
    // items
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
                b -> b.lang("%s Universal Circuit".formatted(GTValues.VNF[tier])).tag(Reference.CIRCUIT_TAGS[tier]));
    }

    public static ItemEntry<Item> constructBasicItem(String name) {
        return constructItem(name, Item::new);
    }
    public static ItemEntry<Item> constructBasicItem(String name, String lang) {
        return constructItem(name, Item::new, b -> b.lang(lang));
    }

    // gt covers
    public static ItemEntry<Item> constructElectricMotor(int tier) {
        String name = GTValues.VN[tier].toLowerCase() + "_electric_motor";
        return constructItem(name, Item::new,
                b -> b.lang("%s Electric Motor".formatted(GTValues.VN[tier])).tag(CustomTags.ELECTRIC_MOTORS));
    }

    public static ItemEntry<Item> constructElectricPump(int tier) {
        String name = GTValues.VN[tier].toLowerCase() + "_electric_pump";
        return constructItem(name, Item::new,
                b -> b.lang("%s Electric Pump".formatted(GTValues.VN[tier])).tag(CustomTags.ELECTRIC_PUMPS));
    }

    public static ItemEntry<Item> constructFluidRegulator(int tier) {
        String name = GTValues.VN[tier].toLowerCase() + "_fluid_regulator";
        return constructItem(name, Item::new,
                b -> b.lang("%s Fluid Regulator".formatted(GTValues.VN[tier])).tag(CustomTags.FLUID_REGULATORS));
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

    // blocks
    public static <T extends Block> BlockEntry<T> constructBlock(String name, NonNullFunction<BlockBehaviour.Properties, T> factory, Consumer<BlockBuilder<T, ?>> customizer) {
        ResourceLocation texture = EvolutionCoreMod.id("block/" + name);
        return Reference.REGISTRATE.block(name, factory).transform(b -> { customizer.accept(b); return b; }).blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), prov.models().cubeAll(ctx.getName(), texture))).defaultLoot().simpleItem().register();
    }
    public static <T extends Block> BlockEntry<T> constructBlock(String name, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        return constructBlock(name, factory, b -> {});
    }
    public static BlockEntry<Block> constructBasicBlock(String name) {
        return constructBlock(name, Block::new);
    }
    public static BlockEntry<Block> constructBasicBlock(String name, String lang) {
        return constructBlock(name, Block::new, b -> b.lang(lang));
    }

    // modified from astrocore by hazevista
    public record FireboxInfo(String name, ResourceLocation top, ResourceLocation bottom, ResourceLocation side) {}

    public static BlockEntry<ActiveBlock> constructFirebox(FireboxInfo info, String lang) {
        return Reference.REGISTRATE.block(info.name + "_casing", ActiveBlock::new)
                .initialProperties(() -> Blocks.STONE)
                .addLayer(() -> RenderType::cutoutMipped)
                .addLayer(() -> RenderType::translucent)
                .blockstate((ctx, prov) -> {
                    ModelFile inactive = prov.models().cubeBottomTop(ctx.getName(), info.side, info.bottom, info.top);
                    ModelFile active = prov.models()
                            .withExistingParent(ctx.getName() + "_active",
                                    new ResourceLocation("gtceu", "block/fire_box_active"))
                            .texture("side", info.side).texture("bottom", info.bottom).texture("top", info.top);
                    prov.getVariantBuilder(ctx.getEntry())
                            .partialState().with(GTBlockStateProperties.ACTIVE, false).modelForState()
                            .modelFile(inactive).addModel()
                            .partialState().with(GTBlockStateProperties.ACTIVE, true).modelForState().modelFile(active)
                            .addModel();
                })
                .lang(lang)
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .item(BlockItem::new).build().register();
    }
}
