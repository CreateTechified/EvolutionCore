package io.github.createtechified.evolutioncore.common.machine.primitive;

import brachy.modularui.api.ITheme;
import brachy.modularui.api.drawable.Text;
import brachy.modularui.api.widget.IGuiAction;
import brachy.modularui.drawable.progress.ProgressDrawable;
import brachy.modularui.factory.PosGuiData;
import brachy.modularui.screen.UISettings;
import brachy.modularui.theme.ThemeAPI;
import brachy.modularui.value.sync.DoubleSyncValue;
import brachy.modularui.value.sync.ItemSlotSyncHandler;
import brachy.modularui.value.sync.PanelSyncManager;
import brachy.modularui.widget.ParentWidget;
import brachy.modularui.widgets.ProgressWidget;
import brachy.modularui.widgets.SlotGroupWidget;
import brachy.modularui.widgets.layout.Flow;
import brachy.modularui.widgets.slot.ItemSlot;
import brachy.modularui.widgets.slot.ModularSlot;
import brachy.modularui.widgets.slot.SlotGroup;
import com.gregtechceu.gtceu.api.blockentity.BlockEntityCreationInfo;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.PrimitiveBlastFurnaceMachine;
import com.gregtechceu.gtceu.common.mui.GTGuiTextures;
import com.gregtechceu.gtceu.utils.GTUtil;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.chat.Component;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Arrays;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PrimitiveAlloyKilnMachine extends PrimitiveBlastFurnaceMachine {
    public PrimitiveAlloyKilnMachine(BlockEntityCreationInfo info) {
        super(info);
    }

    @Override
    public void buildMainUI(ParentWidget<?> mainWidget, PosGuiData guiData, PanelSyncManager syncManager,
                            UISettings settings) {
        ITheme theme = ThemeAPI.INSTANCE.getTheme(getDefinition().getThemeId());

        DoubleSyncValue progressPercent = syncManager.getOrCreateSyncHandler("progressPercent", DoubleSyncValue.class,
                () -> new DoubleSyncValue(() -> {
                    if (recipeLogic == null) return -1f;
                    return recipeLogic.getProgressPercent();
                }));

        var row = Flow.row().coverChildren().center();

        var progressWidget = new ProgressWidget()
                .value(progressPercent)
                .size(20, 15)
                .texture(GTGuiTextures.PRIMITIVE_BLAST_FURNACE_PROGRESS_BAR, ProgressDrawable.Direction.RIGHT)
                .margin(5, 5, 0, 0)
                .tooltip(r -> r.add(Text.comp(Component.translatable("gtceu.recipe_type.show_recipes"))));

        progressWidget.listenGuiAction((IGuiAction.MousePressed) (guiContext, i) -> {
            if (!guiContext.isMouseAbove(progressWidget)) return false;
            if (!GTRecipeTypes.PRIMITIVE_BLAST_FURNACE_RECIPES.getCategory().isXEIVisible()) return false;
            GTUtil.openRecipeViewerCategory(GTRecipeTypes.PRIMITIVE_BLAST_FURNACE_RECIPES.getCategory());
            return true;
        });

        row.child(createImportItemSlot(syncManager, theme))
                .child(progressWidget)
                .child(createExportItemSlot(syncManager, theme));

        mainWidget.child(row);
    }

    private SlotGroupWidget createImportItemSlot(PanelSyncManager syncManager, ITheme theme) {
        int size = importItems.storage.getSlots();
        SlotGroup slotGroup = new SlotGroup("import", size);
        String[] matrix = new String[size];
        char key = 'I';
        Arrays.fill(matrix, String.valueOf(key));
        return SlotGroupWidget.builder()
                .matrix(matrix)
                .key(key, i -> {
                    ModularSlot slot = new ModularSlot(importItems.storage, i);
                    ItemSlotSyncHandler syncHandler = new ItemSlotSyncHandler(slot.slotGroup(slotGroup));
                    syncManager.syncValue("import", i, syncHandler);
                    return new ItemSlot()
                            .syncHandler("import", i)
                            .background(theme.getItemSlotTheme().theme().getBackground(),
                                    (i == 0) ? GTGuiTextures.PRIMITIVE_INGOT_OVERLAY : (i == 1) ?
                                                                                       GTGuiTextures.PRIMITIVE_INGOT_OVERLAY :
                                                                                       GTGuiTextures.PRIMITIVE_FURNACE_OVERLAY);
                })
                .build();
    }

    private SlotGroupWidget createExportItemSlot(PanelSyncManager syncManager, ITheme theme) {
        int size = exportItems.storage.getSlots();
        SlotGroup slotGroup = new SlotGroup("export", size);
        String[] matrix = new String[1];
        char key = 'I';
        matrix[0] = String.valueOf(key).repeat(size);
        return SlotGroupWidget.builder()
                .matrix(matrix)
                .key(key, i -> {
                    ModularSlot slot = new ModularSlot(exportItems.storage, i);
                    slot.accessibility(false, true);
                    ItemSlotSyncHandler syncHandler = new ItemSlotSyncHandler(slot.slotGroup(slotGroup));
                    syncManager.syncValue("export", i, syncHandler);
                    return new ItemSlot()
                            .syncHandler("export", i)
                            .background(theme.getItemSlotTheme().theme().getBackground(),
                                    (i == 0) ? GTGuiTextures.PRIMITIVE_INGOT_OVERLAY :
                                            GTGuiTextures.PRIMITIVE_DUST_OVERLAY);
                })
                .build();
    }
}