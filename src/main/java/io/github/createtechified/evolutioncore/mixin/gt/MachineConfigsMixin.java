package io.github.createtechified.evolutioncore.mixin.gt;

import com.gregtechceu.gtceu.config.ConfigHolder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ConfigHolder.MachineConfigs.class)
@SuppressWarnings("unused")
public class MachineConfigsMixin {
    @Shadow public boolean requireGTToolsForBlocks;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void overrideRequireGTTools(CallbackInfo ci) {
        this.requireGTToolsForBlocks = false;
    }
}
