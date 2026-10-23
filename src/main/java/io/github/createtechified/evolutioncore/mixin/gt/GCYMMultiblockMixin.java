package io.github.createtechified.evolutioncore.mixin.gt;

import brachy.modularui.api.drawable.Text;
import brachy.modularui.value.sync.BooleanSyncValue;
import brachy.modularui.value.sync.IntSyncValue;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.MachineInstanceFactory;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.api.registry.registrate.builder.MultiblockMachineBuilder;
import com.gregtechceu.gtceu.api.registry.registrate.entry.MachineEntry;
import com.gregtechceu.gtceu.common.data.GTRecipeModifiers;
import com.gregtechceu.gtceu.common.data.machines.GCYMMachines;
import com.gregtechceu.gtceu.utils.FormattingUtil;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.createtechified.evolutioncore.common.data.machine.electric.FixedHeatingCoilElectricMultiblock;
import io.github.createtechified.evolutioncore.common.registry.recipes.EvoRecipeModifiers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

import java.util.Collections;
import java.util.function.Consumer;

@Mixin(GCYMMachines.class)
public class GCYMMultiblockMixin {
    @Unique
    private static Consumer<MultiblockMachineBuilder<?>> evoc$pending;

    @Redirect(method = "<clinit>", at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;", ordinal = 12), remap = false, require = 1)
    private static MultiblockMachineBuilder<FixedHeatingCoilElectricMultiblock> ALLOY_BLAST_SMELTER(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        System.out.println("hi im " + name);
        evoc$pending = b -> b.recipeModifiers(EvoRecipeModifiers::ebfOverclock)
                .additionalDisplay((controller, syncManager) -> {
                    if (!(controller instanceof FixedHeatingCoilElectricMultiblock coilMachine))
                        return Collections.emptyList();
                    BooleanSyncValue isFormed = syncManager.getOrCreateSyncHandler("isFormed", BooleanSyncValue.class,
                            () -> new BooleanSyncValue(controller::isFormed));
                    IntSyncValue coilTemperature = syncManager.getOrCreateSyncHandler("coilTemperature", IntSyncValue.class,
                            () -> new IntSyncValue(() -> coilMachine.getCoilType().getCoilTemperature()));
                    IntSyncValue machineTier = syncManager.getOrCreateSyncHandler("machineTier", IntSyncValue.class,
                            () -> new IntSyncValue(coilMachine::getTier));

                    return Collections.singletonList(Text
                            .dynamic(() -> Component.translatable("gtceu.multiblock.blast_furnace.max_temperature",
                                    Component.literal(
                                                    FormattingUtil.formatNumbers(coilTemperature.getIntValue() +
                                                            100L * Math.max(0, machineTier.getIntValue() - GTValues.MV)) + "K")
                                            .setStyle(Style.EMPTY.withColor(ChatFormatting.RED))))
                            .asWidget().setEnabledIf(w -> isFormed.getBoolValue()));
                });
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }
    @Redirect(method = "<clinit>", slice = @Slice(from = @At(value = "CONSTANT", args = "stringValue=rotary_hearth_furnace")), at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/GTRegistrate;multiblock(Ljava/lang/String;Lcom/gregtechceu/gtceu/api/machine/MachineInstanceFactory;)Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;", ordinal = 0), remap = false, require = 1)
    private static MultiblockMachineBuilder<FixedHeatingCoilElectricMultiblock> ROTARY_HEARTH_FURNACE(GTRegistrate registrate, String name, MachineInstanceFactory<FixedHeatingCoilElectricMultiblock> blockEntityFactory) {
        System.out.println("hi im " + name);
        evoc$pending = b -> b.recipeModifiers(GTRecipeModifiers.PARALLEL_HATCH, EvoRecipeModifiers::ebfOverclock, GTRecipeModifiers.BATCH_MODE)
                .additionalDisplay((controller, syncManager) -> {
                    if (!(controller instanceof FixedHeatingCoilElectricMultiblock coilMachine))
                        return Collections.emptyList();
                    BooleanSyncValue isFormed = syncManager.getOrCreateSyncHandler("isFormed", BooleanSyncValue.class,
                            () -> new BooleanSyncValue(controller::isFormed));
                    IntSyncValue coilTemperature = syncManager.getOrCreateSyncHandler("coilTemperature", IntSyncValue.class,
                            () -> new IntSyncValue(() -> coilMachine.getCoilType().getCoilTemperature()));
                    IntSyncValue machineTier = syncManager.getOrCreateSyncHandler("machineTier", IntSyncValue.class,
                            () -> new IntSyncValue(coilMachine::getTier));

                    return Collections.singletonList(Text
                            .dynamic(() -> Component.translatable("gtceu.multiblock.blast_furnace.max_temperature",
                                    Component.literal(
                                                    FormattingUtil.formatNumbers(coilTemperature.getIntValue() +
                                                            100L * Math.max(0, machineTier.getIntValue() - GTValues.MV)) + "K")
                                            .setStyle(Style.EMPTY.withColor(ChatFormatting.RED))))
                            .asWidget().setEnabledIf(w -> isFormed.getBoolValue()));
                });
        return registrate.multiblock(name, FixedHeatingCoilElectricMultiblock::new);
    }

    @WrapOperation(method = "<clinit>", remap = false, at = @At(value = "INVOKE", target = "Lcom/gregtechceu/gtceu/api/registry/registrate/builder/MultiblockMachineBuilder;register()Lcom/gregtechceu/gtceu/api/registry/registrate/entry/MachineEntry;"))
    private static MachineEntry<MultiblockMachineDefinition> evoc$applyPending(MultiblockMachineBuilder<?> builder, Operation<MachineEntry<MultiblockMachineDefinition>> original) {
        var p = evoc$pending;
        evoc$pending = null;
        if (p != null) p.accept(builder);
        return original.call(builder);
    }
}
