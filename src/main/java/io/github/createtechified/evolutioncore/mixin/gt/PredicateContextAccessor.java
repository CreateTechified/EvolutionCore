package io.github.createtechified.evolutioncore.mixin.gt;

import com.gregtechceu.gtceu.api.multiblock.PredicateContext;
import com.gregtechceu.gtceu.api.multiblock.pattern.PatternState;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(PredicateContext.class)
public interface PredicateContextAccessor {
    @Accessor("state")
    @Nullable
    PatternState evoc$getPatternState();
}
