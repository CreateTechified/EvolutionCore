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
import net.minecraft.tags.TagKey;
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
    public static <T extends Item> ItemEntry<T> constructHandheldItem(String name, ResourceLocation texture, NonNullFunction<Item.Properties, T> factory, Consumer<ItemBuilder<T, ?>> customizer) {
        return Reference.REGISTRATE.item(name, factory).transform(b -> {
            customizer.accept(b);
            return b;
        }).model((ctx, prov) -> prov.handheld(ctx, texture)).register();
    }

    public static <T extends Item> ItemEntry<T> constructItem(String name, ResourceLocation texture, NonNullFunction<Item.Properties, T> factory, Consumer<ItemBuilder<T, ?>> customizer) {
        return Reference.REGISTRATE.item(name, factory).transform(b -> {
            customizer.accept(b);
            return b;
        }).model((ctx, prov) -> prov.generated(ctx, texture)).register();
    }

    public static <T extends Item> ItemEntry<T> constructItem(String name, ResourceLocation texture, NonNullFunction<Item.Properties, T> factory) {
        return constructItem(name, texture, factory, b -> {});
    }

    public static ItemEntry<Item> constructUniversalCircuit(int tier) {
        String name = "universal_circuit_" + GTValues.VN[tier].toLowerCase();
        ResourceLocation texture = EvolutionCoreMod.id("item/circuits/" + GTValues.VN[tier].toLowerCase());
        return constructItem(name, texture, Item::new,
                b -> b.lang("%s Universal Circuit".formatted(GTValues.VNF[tier])).tag(Reference.CIRCUIT_TAGS[tier]));
    }

    public static ItemEntry<Item> constructBasicItem(String name) {
        return constructItem(name, EvolutionCoreMod.id("item/" + name), Item::new);
    }
    public static ItemEntry<Item> constructBasicItem(String name, ResourceLocation texture) {
        return constructItem(name, texture, Item::new);
    }
    public static ItemEntry<Item> constructBasicItem(String name, ResourceLocation texture, String lang) {
        return constructItem(name, texture, Item::new, b -> b.lang(lang));
    }

    // gt covers
    public static ItemEntry<Item> constructCoverlessCover(int tier, String type, String lang, TagKey<Item> tag) {
        String name = GTValues.VN[tier].toLowerCase() + "_" + type;
        return constructItem(name, EvolutionCoreMod.id("item/covers/" + name), Item::new,
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

    // blocks
    public static <T extends Block> BlockEntry<T> constructBlock(String name, ResourceLocation texture, NonNullFunction<BlockBehaviour.Properties, T> factory, Consumer<BlockBuilder<T, ?>> customizer) {
        return Reference.REGISTRATE.block(name, factory).transform(b -> { customizer.accept(b); return b; }).blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), prov.models().cubeAll(ctx.getName(), texture))).defaultLoot().simpleItem().register();
    }
    public static <T extends Block> BlockEntry<T> constructBlock(String name, ResourceLocation texture, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        return constructBlock(name, texture, factory, b -> {});
    }
    public static BlockEntry<Block> constructBasicBlock(String name) {
        return constructBlock(name, EvolutionCoreMod.id("block/" + name), Block::new);
    }
    public static BlockEntry<Block> constructBasicBlock(String name, String lang) {
        return constructBlock(name, EvolutionCoreMod.id("block/" + name), Block::new, b -> b.lang(lang));
    }
    public static BlockEntry<Block> constructBasicBlock(String name, Block ref) {
        return constructBlock(name, EvolutionCoreMod.id("block/" + name), Block::new, b -> b.initialProperties(() -> ref));
    }
    public static BlockEntry<Block> constructBasicBlock(String name, String lang, Block ref) {
        return constructBlock(name, EvolutionCoreMod.id("block/" + name), Block::new, b -> b.lang(lang).initialProperties(() -> ref));
    }
    public static BlockEntry<Block> constructBasicBlock(String name, ResourceLocation texture) {
        return constructBlock(name, texture, Block::new);
    }
    public static BlockEntry<Block> constructBasicBlock(String name, ResourceLocation texture, String lang) {
        return constructBlock(name, texture, Block::new, b -> b.lang(lang));
    }
    public static BlockEntry<Block> constructBasicBlock(String name, ResourceLocation texture, Block ref) {
        return constructBlock(name, texture, Block::new, b -> b.initialProperties(() -> ref));
    }
    public static BlockEntry<Block> constructBasicBlock(String name, ResourceLocation texture, String lang, Block ref) {
        return constructBlock(name, texture, Block::new, b -> b.lang(lang).initialProperties(() -> ref));
    }
    public static BlockEntry<Block> constructCasingBlock(String name, String type, String lang) {
        return constructBlock(name, EvolutionCoreMod.id("block/casings/" + type + "/" + name), Block::new,
                b -> b.lang(lang).initialProperties(() -> Blocks.IRON_BLOCK));
    }

    // modified from astrocore by hazevista
    public record FireboxInfo(String name, ResourceLocation top, ResourceLocation bottom, ResourceLocation side) {}

    public static BlockEntry<ActiveBlock> constructFirebox(FireboxInfo info, String lang) {
        return Reference.REGISTRATE.block(info.name, ActiveBlock::new)
                .initialProperties(() -> Blocks.IRON_BLOCK)
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
