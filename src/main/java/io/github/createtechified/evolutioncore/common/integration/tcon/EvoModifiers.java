package io.github.createtechified.evolutioncore.common.integration.tcon;

import io.github.createtechified.evolutioncore.Reference;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.modifiers.util.DynamicModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;

public class EvoModifiers {
    public static ModifierDeferredRegister MODIFIERS = ModifierDeferredRegister.create(Reference.MODID);

    public static final DynamicModifier MATHEMATICAL_MODIFIER = MODIFIERS.registerDynamic("mathematical");
    public static final DynamicModifier MODIFIABLE_MODIFIER = MODIFIERS.registerDynamic("modifiable");
    public static final ModifierId mathematical = id("mathematical");
    public static final ModifierId modifiable = id("modifiable");

    private static ModifierId id(String name) {
        return new ModifierId(Reference.MODID, name);
    }
}
