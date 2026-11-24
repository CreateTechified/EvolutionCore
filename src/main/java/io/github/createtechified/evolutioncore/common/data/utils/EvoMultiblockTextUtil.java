package io.github.createtechified.evolutioncore.common.data.utils;

import brachy.modularui.api.drawable.Text;
import brachy.modularui.screen.RichTooltip;
import brachy.modularui.value.sync.BooleanSyncValue;
import brachy.modularui.value.sync.IntSyncValue;
import brachy.modularui.value.sync.LongSyncValue;
import brachy.modularui.value.sync.PanelSyncManager;
import brachy.modularui.widgets.TextWidget;
import brachy.modularui.widgets.layout.Flow;
import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.common.mui.GTMultiblockTextUtil;
import io.github.createtechified.evolutioncore.common.data.machine.steam.HPSteamParallelMultiblockMachine;
import io.github.createtechified.evolutioncore.common.data.machine.steam.LPSteamParallelMultiblockMachine;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import java.util.function.Supplier;

public class EvoMultiblockTextUtil {
    // LPSteamParallelMultiblockMachine
    public static TextWidget<?> addEnergyTierLine(LPSteamParallelMultiblockMachine rlMachine, PanelSyncManager syncManager) {
        BooleanSyncValue isFormed = syncManager.getOrCreateSyncHandler("isFormed", BooleanSyncValue.class,
                () -> new BooleanSyncValue(rlMachine::isFormed));

        IntSyncValue tier = syncManager.getOrCreateSyncHandler("energyTier", IntSyncValue.class,
                () -> new IntSyncValue(rlMachine::getRecipeTier));

        return Text.dynamic(() -> {
                    Component voltageName = Component.literal(GTValues.VNF[tier.getIntValue()]);
                    return Component.translatable(
                            "gtceu.multiblock.max_recipe_tier",
                            voltageName).withStyle(ChatFormatting.GRAY);
                })
                .asWidget()
                .tooltip(new RichTooltip().add(Component.translatable("gtceu.multiblock.max_recipe_tier_hover")
                        .withStyle(ChatFormatting.GRAY)))
                .setEnabledIf(widget -> isFormed.getBoolValue());
    }
    public static Flow addEnergyUsageLine(LPSteamParallelMultiblockMachine weMachine, PanelSyncManager syncManager) {
        LongSyncValue maxEnergyUsage = syncManager.getOrCreateSyncHandler("maxEnergyUsage", LongSyncValue.class,
                () -> new LongSyncValue(() -> GTValues.V[weMachine.getRecipeTier()]));
        LongSyncValue voltage = syncManager.getOrCreateSyncHandler("machineVoltage", LongSyncValue.class,
                () -> new LongSyncValue(weMachine::getDisplayRecipeVoltage));

        BooleanSyncValue isFormed = syncManager.getOrCreateSyncHandler("isFormed", BooleanSyncValue.class,
                () -> new BooleanSyncValue(weMachine::isFormed));

        return GTMultiblockTextUtil.buildAmpVoltEutHoverLine(
                () -> Component.translatable("gtceu.multiblock.general.max_power",
                                GTMultiblockTextUtil.buildAmpVoltComponent(maxEnergyUsage, voltage))
                        .withStyle(ChatFormatting.GRAY),
                GTMultiblockTextUtil.buildEutHoverTooltip(maxEnergyUsage, true),
                ($ -> isFormed.getBoolValue()));
    }
    public static Flow addEnergyUsageExactLine(LPSteamParallelMultiblockMachine weMachine, PanelSyncManager syncManager) {
        BooleanSyncValue isFormed = syncManager.getOrCreateSyncHandler("isFormed", BooleanSyncValue.class,
                () -> new BooleanSyncValue(weMachine::isFormed));
        BooleanSyncValue isActive = syncManager.getOrCreateSyncHandler("isActive", BooleanSyncValue.class,
                () -> new BooleanSyncValue(weMachine::isActive));
        BooleanSyncValue isWaiting = syncManager.getOrCreateSyncHandler("isWaiting", BooleanSyncValue.class,
                () -> new BooleanSyncValue(weMachine::isWaiting));
        BooleanSyncValue isSuspend = syncManager.getOrCreateSyncHandler("isSuspend", BooleanSyncValue.class,
                () -> new BooleanSyncValue(weMachine::isSuspend));
        LongSyncValue energyUsage = syncManager.getOrCreateSyncHandler("energyUsage", LongSyncValue.class,
                () -> new LongSyncValue(weMachine::getRecipeEUt));
        LongSyncValue displayVoltage = syncManager.getOrCreateSyncHandler("machineVoltage", LongSyncValue.class,
                () -> new LongSyncValue(weMachine::getDisplayRecipeVoltage));

        Supplier<Component> productionLine = () -> {
            if (isWaiting.getBoolValue() || isSuspend.getBoolValue()) {
                return Component.translatable(("gtceu.multiblock.general.energy_consumption_waiting"),
                                GTMultiblockTextUtil.buildAmpVoltComponent(energyUsage, displayVoltage))
                        .withStyle(ChatFormatting.GRAY);
            } else {
                return Component.translatable(("gtceu.multiblock.general.energy_consumption"),
                                GTMultiblockTextUtil.buildAmpVoltComponent(energyUsage, displayVoltage))
                        .withStyle(ChatFormatting.GRAY);
            }
        };

        return GTMultiblockTextUtil.buildAmpVoltEutHoverLine(productionLine,
                GTMultiblockTextUtil.buildEutHoverTooltip(energyUsage, false),
                (flow -> isFormed.getBoolValue() && isActive.getBoolValue()));
    }
    // HPSteamParallelMultiblockMachine
    public static TextWidget<?> addEnergyTierLine(HPSteamParallelMultiblockMachine rlMachine, PanelSyncManager syncManager) {
        BooleanSyncValue isFormed = syncManager.getOrCreateSyncHandler("isFormed", BooleanSyncValue.class,
                () -> new BooleanSyncValue(rlMachine::isFormed));

        IntSyncValue tier = syncManager.getOrCreateSyncHandler("energyTier", IntSyncValue.class,
                () -> new IntSyncValue(rlMachine::getRecipeTier));

        return Text.dynamic(() -> {
                    Component voltageName = Component.literal(GTValues.VNF[tier.getIntValue()]);
                    return Component.translatable(
                            "gtceu.multiblock.max_recipe_tier",
                            voltageName).withStyle(ChatFormatting.GRAY);
                })
                .asWidget()
                .tooltip(new RichTooltip().add(Component.translatable("gtceu.multiblock.max_recipe_tier_hover")
                        .withStyle(ChatFormatting.GRAY)))
                .setEnabledIf(widget -> isFormed.getBoolValue());
    }
    public static Flow addEnergyUsageLine(HPSteamParallelMultiblockMachine weMachine, PanelSyncManager syncManager) {
        LongSyncValue maxEnergyUsage = syncManager.getOrCreateSyncHandler("maxEnergyUsage", LongSyncValue.class,
                () -> new LongSyncValue(() -> GTValues.V[weMachine.getRecipeTier()]));
        LongSyncValue voltage = syncManager.getOrCreateSyncHandler("machineVoltage", LongSyncValue.class,
                () -> new LongSyncValue(weMachine::getDisplayRecipeVoltage));

        BooleanSyncValue isFormed = syncManager.getOrCreateSyncHandler("isFormed", BooleanSyncValue.class,
                () -> new BooleanSyncValue(weMachine::isFormed));

        return GTMultiblockTextUtil.buildAmpVoltEutHoverLine(
                () -> Component.translatable("gtceu.multiblock.general.max_power",
                                GTMultiblockTextUtil.buildAmpVoltComponent(maxEnergyUsage, voltage))
                        .withStyle(ChatFormatting.GRAY),
                GTMultiblockTextUtil.buildEutHoverTooltip(maxEnergyUsage, true),
                ($ -> isFormed.getBoolValue()));
    }
    public static Flow addEnergyUsageExactLine(HPSteamParallelMultiblockMachine weMachine, PanelSyncManager syncManager) {
        BooleanSyncValue isFormed = syncManager.getOrCreateSyncHandler("isFormed", BooleanSyncValue.class,
                () -> new BooleanSyncValue(weMachine::isFormed));
        BooleanSyncValue isActive = syncManager.getOrCreateSyncHandler("isActive", BooleanSyncValue.class,
                () -> new BooleanSyncValue(weMachine::isActive));
        BooleanSyncValue isWaiting = syncManager.getOrCreateSyncHandler("isWaiting", BooleanSyncValue.class,
                () -> new BooleanSyncValue(weMachine::isWaiting));
        BooleanSyncValue isSuspend = syncManager.getOrCreateSyncHandler("isSuspend", BooleanSyncValue.class,
                () -> new BooleanSyncValue(weMachine::isSuspend));
        LongSyncValue energyUsage = syncManager.getOrCreateSyncHandler("energyUsage", LongSyncValue.class,
                () -> new LongSyncValue(weMachine::getRecipeEUt));
        LongSyncValue displayVoltage = syncManager.getOrCreateSyncHandler("machineVoltage", LongSyncValue.class,
                () -> new LongSyncValue(weMachine::getDisplayRecipeVoltage));

        Supplier<Component> productionLine = () -> {
            if (isWaiting.getBoolValue() || isSuspend.getBoolValue()) {
                return Component.translatable(("gtceu.multiblock.general.energy_consumption_waiting"),
                                GTMultiblockTextUtil.buildAmpVoltComponent(energyUsage, displayVoltage))
                        .withStyle(ChatFormatting.GRAY);
            } else {
                return Component.translatable(("gtceu.multiblock.general.energy_consumption"),
                                GTMultiblockTextUtil.buildAmpVoltComponent(energyUsage, displayVoltage))
                        .withStyle(ChatFormatting.GRAY);
            }
        };

        return GTMultiblockTextUtil.buildAmpVoltEutHoverLine(productionLine,
                GTMultiblockTextUtil.buildEutHoverTooltip(energyUsage, false),
                (flow -> isFormed.getBoolValue() && isActive.getBoolValue()));
    }
}
