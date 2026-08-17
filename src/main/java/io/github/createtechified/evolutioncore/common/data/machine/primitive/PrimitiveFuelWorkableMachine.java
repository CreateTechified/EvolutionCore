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
public class PrimitiveFuelWorkableMachine extends PrimitiveWorkableMachine {

    @SaveField
    public final NotifiableItemStackHandler fuelItems;

    @SaveField
    private int fuelTicksLeft = 0;

    @SaveField
    private int fuelMaxTicks = 0;

    private @Nullable TickableSubscription fuelSubscription;

    public PrimitiveFuelWorkableMachine(BlockEntityCreationInfo info, RecipeLogic recipeLogic, int importSlots,
                                        int exportSlots, int fluidImportSlots, int fluidExportSlots,
                                        int tankCapacity, int fuelSlots) {
        super(info, recipeLogic, importSlots, exportSlots, fluidImportSlots, fluidExportSlots, tankCapacity);
        this.fuelItems = attachTrait(new NotifiableItemStackHandler(fuelSlots, IO.IN));
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
        if (recipeLogic.isWorking() && fuelTicksLeft > 0) {
            fuelTicksLeft--;
            if (fuelTicksLeft == 0) {
                fuelMaxTicks = 0;
            }
        }
        if (fuelTicksLeft <= 0) {
            for (int i = 0; i < fuelItems.storage.getSlots(); i++) {
                ItemStack stack = fuelItems.storage.getStackInSlot(i);
                if (stack.isEmpty()) continue;
                int burnTime = ForgeHooks.getBurnTime(stack, null);
                if (burnTime > 0) {
                    fuelItems.storage.extractItem(i, 1, false);
                    fuelTicksLeft = burnTime;
                    fuelMaxTicks = burnTime;
                    System.out.println("[EvoDebug] fuel burnTime = " + burnTime); // temporary
                    return;
                }
            }
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