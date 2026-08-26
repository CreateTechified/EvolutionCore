package io.github.createtechified.evolutioncore.common.registry.utils;

import com.gregtechceu.gtceu.api.block.ActiveBlock;
import com.gregtechceu.gtceu.api.block.property.GTBlockStateProperties;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import io.github.createtechified.evolutioncore.EvolutionCoreMod;
import io.github.createtechified.evolutioncore.Reference;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Consumer;

@SuppressWarnings("unused")
public class BlockConstructors {
    public static <T extends Block> BlockEntry<T> constructBlock(String name, ResourceLocation texture, NonNullFunction<BlockBehaviour.Properties, T> factory, Consumer<BlockBuilder<T, ?>> customizer) {
        return Reference.REGISTRATE.block(name, factory).transform(b -> { customizer.accept(b); return b; }).blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), prov.models().cubeAll(ctx.getName(), texture))).defaultLoot().simpleItem().register();
    }
    public static <T extends Block> BlockEntry<T> constructBlock(String name, ResourceLocation texture, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        return constructBlock(name, texture, factory, b -> {});
    }
    public static <T extends Block> BlockEntry<T> constructSidedBlock(String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, NonNullFunction<BlockBehaviour.Properties, T> factory, Consumer<BlockBuilder<T, ?>> customizer) {
        return Reference.REGISTRATE.block(name, factory).transform(b -> { customizer.accept(b); return b; }).blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(), prov.models().cubeBottomTop(ctx.getName(), side, bottom, top))).defaultLoot().simpleItem().register();
    }
    public static <T extends Block> BlockEntry<T> constructSidedBlock(String name, ResourceLocation side, ResourceLocation bottom, ResourceLocation top, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        return constructSidedBlock(name, side, bottom, top, factory, b -> {});
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
    public static BlockEntry<Block> constructSteamCasingBlock(String name, String lang) {
        return constructBlock(name, EvolutionCoreMod.id("block/casings/steam/" + name), Block::new,
                b -> b.lang(lang).initialProperties(() -> Blocks.IRON_BLOCK).tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH));
    }
    public static BlockEntry<Block> constructFusionCasingBlock(String name, String texture, String lang) {
        return constructBlock(name, EvolutionCoreMod.id("block/casings/fusion/" + texture), Block::new,
                b -> b.lang(lang).initialProperties(() -> Blocks.IRON_BLOCK).tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH).properties(p -> p.isValidSpawn((state, level, pos, ent) -> false)));
    }
    public static BlockEntry<Block> constructCasingBlock(String name, String type, String lang) {
        return constructBlock(name, EvolutionCoreMod.id("block/casings/" + type + "/casing"), Block::new,
                b -> b.lang(lang).initialProperties(() -> Blocks.IRON_BLOCK).tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH));
    }
    public static BlockEntry<Block> constructSolidCasingBlock(String name, String type, String lang) {
        ResourceLocation side = EvolutionCoreMod.id("block/casings/" + type + "/side");
        ResourceLocation bottom = EvolutionCoreMod.id("block/casings/" + type + "/bottom");
        ResourceLocation top = EvolutionCoreMod.id("block/casings/" + type + "/top");
        return constructSidedBlock(name, side, bottom, top, Block::new,
                b -> b.lang(lang).initialProperties(() -> Blocks.IRON_BLOCK).tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH));
    }
    public static BlockEntry<Block> constructPipeCasingBlock(String name, String type, String lang) {
        return constructBlock(name, EvolutionCoreMod.id("block/casings/" + type + "/pipe"), Block::new,
                b -> b.lang(lang).initialProperties(() -> Blocks.IRON_BLOCK).tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH));
    }
    public static BlockEntry<Block> constructGearboxCasingBlock(String name, String type, String lang) {
        return constructBlock(name, EvolutionCoreMod.id("block/casings/" + type + "/gearbox"), Block::new,
                b -> b.lang(lang).initialProperties(() -> Blocks.IRON_BLOCK).tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH));
    }
    public static BlockEntry<Block> constructTurbineCasingBlock(String name, String type, String lang) {
        return constructBlock(name, EvolutionCoreMod.id("block/casings/" + type + "/turbine"), Block::new,
                b -> b.lang(lang).initialProperties(() -> Blocks.IRON_BLOCK).tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH));
    }
}
