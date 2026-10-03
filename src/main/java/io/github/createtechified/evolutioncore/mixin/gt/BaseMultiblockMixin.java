package io.github.createtechified.evolutioncore.mixin.gt;

import com.gregtechceu.gtceu.api.machine.MachineInstanceFactory;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.multiblock.Predicates;
import com.gregtechceu.gtceu.api.multiblock.pattern.MultiblockPatternBuilder;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.api.registry.registrate.builder.MultiblockMachineBuilder;
import com.gregtechceu.gtceu.api.registry.registrate.entry.MachineEntry;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.CokeOvenMachine;
import com.gregtechceu.gtceu.common.machine.multiblock.steam.SteamParallelMultiblockMachine;
import com.gregtechceu.gtceu.utils.GTUtil;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.createtechified.evolutioncore.common.data.EvoPredicates;
import io.github.createtechified.evolutioncore.common.data.machine.electric.FixedHeatingCoilElectricMultiblock;
import io.github.createtechified.evolutioncore.common.data.machine.primitive.PrimitiveBlastFurnace;
import io.github.createtechified.evolutioncore.common.registry.EvoBlocks;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeModifiers;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.multiblock.util.RelativeDirection.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeModifiers.*;
import static net.minecraft.world.level.block.state.properties.Half.*;

@Mixin(GTMultiMachines.class)
public class BaseMultiblockMixin {
    @Unique
    private static Consumer<MultiblockMachineBuilder<?>> evoc$pending;

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;", ordinal = 0), remap = false, require = 1)
    private static MultiblockMachineBuilder<CokeOvenMachine> COKE_OVEN(GTRegistrate registrate, String name, MachineInstanceFactory<CokeOvenMachine> blockEntityFactory) {
        evoc$pending = b -> b.pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                .slice("XXX", "XXX", "BBB", "   ", "   ", "   ")
                .slice("XXX", "XXX", "XXX", "WXW", "WXW", "XUX")
                .slice("XXX", "X#X", "XXX", "XXX", "XXX", "LXR")
                .slice("XXX", "XYX", "XXX", "WXW", "WXW", "XDX")
                .where('Y', Predicates.controller(definition))
                .where('X', Predicates.blocks(GTBlocks.CASING_COKE_BRICKS.get()).and(Predicates.blocks(GTMachines.COKE_OVEN_HATCH.getBlock()).setMaxGlobalLimited(5)))
                .where('B', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), BACK, BOTTOM, true))
                .where('U', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), BACK, TOP, true))
                .where('L', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), LEFT, TOP, true))
                .where('R', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), RIGHT, TOP, true))
                .where('D', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), FRONT, TOP, true))
                .where('W', Predicates.blocks(EvoBlocks.CASING_COKE_BRICK_WALL.get())) // ^ I have commit horrors that would disappoint my ancestors.
                .where('#', Predicates.air())
                .build());
        return registrate.multiblock(name, blockEntityFactory);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;", ordinal = 1), remap = false, require = 1)
    private static MultiblockMachineBuilder<PrimitiveBlastFurnace> PRIMITIVE_BLAST_FURNACE(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        evoc$pending = b -> b.pattern(definition -> MultiblockPatternBuilder.start(FRONT, UP, RIGHT)
                .slice("BUUUB", "     ", "     ", "     ", "     ", "     ")
                .slice("LBBBR", " XIX ", " XXX ", " PXP ", " PXP ", " XIX ")
                .slice("LBBBR", " JXO ", " X&X ", " X#X ", " X#X ", " J#O ")
                .slice("LBBBR", " XKX ", " XYX ", " PXP ", " PXP ", " XKX ")
                .slice("BDDDB", "     ", "     ", "     ", "     ", "     ")
                .where('Y', Predicates.controller(definition))
                .where('X', Predicates.blocks(GTBlocks.CASING_PRIMITIVE_BRICKS.get()))
                .where('B', Predicates.blocks(GTBlocks.CASING_COKE_BRICKS.get()))
                .where('U', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), BACK, BOTTOM, true))
                .where('L', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), LEFT, BOTTOM, true))
                .where('R', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), RIGHT, BOTTOM, true))
                .where('D', EvoPredicates.directionalBlock(EvoBlocks.CASING_COKE_BRICK_STAIRS.get(), FRONT, BOTTOM, true))
                .where('I', EvoPredicates.directionalBlock(EvoBlocks.CASING_PRIMITIVE_BRICK_STAIRS.get(), BACK, TOP, true))
                .where('J', EvoPredicates.directionalBlock(EvoBlocks.CASING_PRIMITIVE_BRICK_STAIRS.get(), LEFT, TOP, true))
                .where('O', EvoPredicates.directionalBlock(EvoBlocks.CASING_PRIMITIVE_BRICK_STAIRS.get(), RIGHT, TOP, true))
                .where('K', EvoPredicates.directionalBlock(EvoBlocks.CASING_PRIMITIVE_BRICK_STAIRS.get(), FRONT, TOP, true))
                .where('P', Predicates.blocks(EvoBlocks.CASING_PRIMITIVE_BRICK_WALL.get()))
                .where('#', Predicates.air())
                .where('&', Predicates.air()
                        .or(Predicates.builder("SnowPredicate")
                                .predicate(ctx -> GTUtil.isBlockSnow(ctx.state()))
                                .toMultiPredicate()
                                .addTooltips(Component.literal("Can be snow"))))
                .build());
        return registrate.multiblock(name, PrimitiveBlastFurnace::new);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;", ordinal = 2), remap = false, require = 1)
    private static MultiblockMachineBuilder<FixedHeatingCoilElectricMultiblock> ELECTRIC_BLAST_FURNACE(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        evoc$pending = b -> b.recipeModifiers(EvoRecipeModifiers::ebfOverclock, BATCH_MODE);
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;", ordinal = 3), remap = false, require = 1)
    private static MultiblockMachineBuilder<FixedHeatingCoilElectricMultiblock> LARGE_CHEMICAL_REACTOR(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        evoc$pending = b -> b.recipeModifiers(DEFAULT_ENVIRONMENT_REQUIREMENT, OC_PERFECT_SUBTICK, BATCH_MODE);
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;", ordinal = 5), remap = false, require = 1)
    private static MultiblockMachineBuilder<FixedHeatingCoilElectricMultiblock> PYROLYSE_OVEN(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        evoc$pending = b -> b.recipeModifiers(EvoRecipeModifiers::pyrolyseOvenOverclock, BATCH_MODE);
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;", ordinal = 6), remap = false, require = 1)
    private static MultiblockMachineBuilder<FixedHeatingCoilElectricMultiblock> MULTI_SMELTER(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        evoc$pending = b -> b.recipeModifiers(EvoRecipeModifiers::multiSmelterParallel, BATCH_MODE);
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;", ordinal = 7), remap = false, require = 1)
    private static MultiblockMachineBuilder<FixedHeatingCoilElectricMultiblock> CRACKER(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        evoc$pending = b -> b.recipeModifiers(EvoRecipeModifiers::crackerOverclock, BATCH_MODE);
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;", ordinal = 12), remap = false, require = 1)
    private static MultiblockMachineBuilder<SteamParallelMultiblockMachine> STEAM_GRINDER(GTRegistrate registrate, String name, MachineInstanceFactory<SteamParallelMultiblockMachine> blockEntityFactory) {
        evoc$pending = b -> b.recipeType(GTRecipeTypes.DUMMY_RECIPES).renderMultiblockWorldPreview(false).renderMultiblockXEIPreview(false);
        return registrate.multiblock(name, blockEntityFactory);
    }
    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;", ordinal = 13), remap = false, require = 1)
    private static MultiblockMachineBuilder<SteamParallelMultiblockMachine> STEAM_OVEN(GTRegistrate registrate, String name, MachineInstanceFactory<SteamParallelMultiblockMachine> blockEntityFactory) {
        evoc$pending = b -> b.recipeType(GTRecipeTypes.DUMMY_RECIPES).renderMultiblockWorldPreview(false).renderMultiblockXEIPreview(false);
        return registrate.multiblock(name, blockEntityFactory);
    }

    @WrapOperation(method = "<clinit>", remap = false, at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;register()Lcom/gregtechceu/gtceu/api/registry/registrate/entry/MachineEntry;"))
    private static MachineEntry<MultiblockMachineDefinition> evoc$applyPending(MultiblockMachineBuilder<?> builder, Operation<MachineEntry<MultiblockMachineDefinition>> original) {
        var p = evoc$pending;
        evoc$pending = null;
        if (p != null) p.accept(builder);
        return original.call(builder);
    }
}