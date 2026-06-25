package io.github.createtechified.evolutioncore.common.integration.tcon;

import io.github.createtechified.evolutioncore.Reference;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

import java.util.Objects;

public class EvoMaterials {
    public static final MaterialId UNSTABLE = Objects.requireNonNull(MaterialId.tryBuild(Reference.MODID, "unstable"));
    public static final MaterialId MAGICAL_WOOD = Objects.requireNonNull(MaterialId.tryBuild(Reference.MODID, "magical_wood"));
}
