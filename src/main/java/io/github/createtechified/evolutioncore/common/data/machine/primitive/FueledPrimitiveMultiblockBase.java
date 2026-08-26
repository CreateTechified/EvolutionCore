package io.github.createtechified.evolutioncore.common.data.machine.primitive;

import com.gregtechceu.gtceu.api.blockentity.BlockEntityCreationInfo;
import com.gregtechceu.gtceu.api.machine.TickableSubscription;
import com.gregtechceu.gtceu.api.machine.trait.notifiable.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.machine.trait.recipe.RecipeLogic;
import com.gregtechceu.gtceu.api.sync_system.annotations.SaveField;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.PrimitiveWorkableMachine;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class FueledPrimitiveMultiblockBase extends PrimitiveWorkableMachine {
    @SaveField
    public final NotifiableItemStackHandler fuelItems;
    @SaveField
    private int fuelTicksLeft = 0;
    @SaveField
    private int fuelMaxTicks = 0;
    private int fuelBurnMultiplier = 1;

    private @Nullable TickableSubscription fuelSubscription;

    public FueledPrimitiveMultiblockBase(BlockEntityCreationInfo info, RecipeLogic recipeLogic, int importSlots,
                                         int exportSlots, int fluidImportSlots, int fluidExportSlots,
                                         int tankCapacity, int fuelSlots) {
        this(info, recipeLogic, importSlots, exportSlots, fluidImportSlots, fluidExportSlots, tankCapacity, fuelSlots, 1);
    }

    public FueledPrimitiveMultiblockBase(BlockEntityCreationInfo info, RecipeLogic recipeLogic, int importSlots,
                                         int exportSlots, int fluidImportSlots, int fluidExportSlots,
                                         int tankCapacity, int fuelSlots, int fuelBurnMultiplier) {
        super(info, recipeLogic, importSlots, exportSlots, fluidImportSlots, fluidExportSlots, tankCapacity);
        this.fuelItems = attachTrait(new NotifiableItemStackHandler(fuelSlots, IO.IN));
        this.fuelBurnMultiplier = fuelBurnMultiplier;
    }

    @Override
    public void onLoad() {
        super.onLoad();
        this.fuelSubscription = subscribeServerTick(this.fuelSubscription, this::tickFuel);
    }

    @Override
    public void onUnload() {
        super.onUnload();
        unsubscribe(fuelSubscription);
        fuelSubscription = null;
    }

    private void tickFuel() {
        if (recipeLogic.isWorking() && hasFuel()) {
            fuelTicksLeft -= fuelBurnMultiplier;
            consumeFuel();
        } else if (!hasFuel()) {
            recipeLogic.setStatus(RecipeLogic.Status.SUSPEND);
            consumeFuel();
        }
    }

    private void consumeFuel() {
        if (fuelTicksLeft <= 0) {
            for (int i = 0; i < fuelItems.storage.getSlots(); i++) {
                ItemStack stack = fuelItems.storage.getStackInSlot(i);
                if (!stack.isEmpty()) {
                    int burnTime = ForgeHooks.getBurnTime(stack, null);
                    if (burnTime > 0) {
                        recipeLogic.setWorkingEnabled(true);
                        fuelItems.storage.extractItem(i, 1, false);
                        fuelTicksLeft = burnTime;
                        fuelMaxTicks = burnTime;
                        return;
                    }
                }
            }
            recipeLogic.setWorkingEnabled(false);
        }
    }

    public boolean hasFuel() {
        return fuelTicksLeft > 0;
    }

    public float getFuelPercent() {
        if (fuelMaxTicks <= 0) return 0f;
        return (float) fuelTicksLeft / fuelMaxTicks;
    }
}