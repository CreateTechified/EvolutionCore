package io.github.createtechified.evolutioncore.common.registry.recipes;

import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import io.github.createtechified.evolutioncore.Reference;
import io.github.createtechified.evolutioncore.common.registry.CreativeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Consumer;

@SuppressWarnings("unused")
public class ModBlocks {
    public static void init() {}

    static {
        Reference.REGISTRATE.creativeModeTab(() -> CreativeTabs.EVOLUTIONCORE_MAIN);
    }

    public static <T extends Block> BlockEntry<T> constructBlock(String name, NonNullFunction<BlockBehaviour.Properties, T> factory, Consumer<BlockBuilder<T, ?>> customizer) {
        return Reference.REGISTRATE.block(name, factory).transform(b -> { customizer.accept(b); return b; }).register();
    }
    public static <T extends Block> BlockEntry<T> constructBlock(String name, NonNullFunction<BlockBehaviour.Properties, T> factory) {
        return constructBlock(name, factory, b -> {});
    }
    public static BlockEntry<Block> constructBasicBlock(String name) {
        return constructBlock(name, Block::new);
    }
}
