package io.github.createtechified.evolutioncore;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"unused", "unchecked"})
public class Reference {
    public static final String MODID = "evolutioncore";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final GTRegistrate REGISTRATE = GTRegistrate.create(Reference.MODID);
    public static final TagKey<Item>[] CIRCUIT_TAGS = new TagKey[] {
            CustomTags.ULV_CIRCUITS,
            CustomTags.LV_CIRCUITS,
            CustomTags.MV_CIRCUITS,
            CustomTags.HV_CIRCUITS,
            CustomTags.EV_CIRCUITS,
            CustomTags.IV_CIRCUITS,
            CustomTags.LuV_CIRCUITS,
            CustomTags.ZPM_CIRCUITS,
            CustomTags.UV_CIRCUITS,
            CustomTags.UHV_CIRCUITS,
            CustomTags.UEV_CIRCUITS,
            CustomTags.UIV_CIRCUITS,
            CustomTags.UXV_CIRCUITS,
            CustomTags.OpV_CIRCUITS,
            CustomTags.MAX_CIRCUITS
    };

    // centralized mod loaded bools
    public static final boolean ML_IntegratedDynamics = ModList.get().isLoaded("integrateddynamics");
    public static final boolean ML_BiomesWeveGone = ModList.get().isLoaded("biomeswevegone");
    public static final boolean ML_Occultism = ModList.get().isLoaded("occultism");
}
