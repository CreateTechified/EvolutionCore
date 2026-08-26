package io.github.createtechified.evolutioncore;

import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.data.machines.GTMultiMachines;
import com.gregtechceu.gtceu.config.ConfigHolder;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.fml.ModList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

@SuppressWarnings({"unused", "unchecked"})
public class Reference {
    public static final String MODID = "evolutioncore";
    public static final Logger LOGGER = LogManager.getLogger("EvolutionCore");
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

    @SuppressWarnings("unchecked")
    public static final Supplier<MultiblockMachineDefinition>[] MACHINES_TO_REMOVE = new Supplier[] {
            () -> GTMultiMachines.STEAM_OVEN,
            () -> GTMultiMachines.STEAM_GRINDER,
            () -> GTMultiMachines.CHARCOAL_PILE_IGNITER
    };

    // GT Configs must use Suppliers!
    public static final Supplier<Boolean> GT_SteelSteamRecipes = () -> ConfigHolder.INSTANCE.machines.steelSteamMultiblocks;
    // If mods are loaded...
    public static final boolean ML_IntegratedDynamics = ModList.get().isLoaded("integrateddynamics");
    public static final boolean ML_BiomesWeveGone = ModList.get().isLoaded("biomeswevegone");
    public static final boolean ML_Occultism = ModList.get().isLoaded("occultism");
}
