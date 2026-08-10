package io.github.createtechified.evolutioncore.common.registry;

import com.gregtechceu.gtceu.common.block.CoilBlock;
import com.tterrag.registrate.util.entry.BlockEntry;
import io.github.createtechified.evolutioncore.common.registry.utils.ActiveBlockConstructors;

public class EvoCoilBlocks {
    public static void init() {}

    public static BlockEntry<CoilBlock> NEURALIC_ALLOY_7_COIL = ActiveBlockConstructors.constructCoilBlock(EvoCoilType.NEURALIC_ALLOY_7);
    public static BlockEntry<CoilBlock> WRLDAPPLE_ALLOY_COIL = ActiveBlockConstructors.constructCoilBlock(EvoCoilType.WRLDAPPLE_ALLOY);
}