package io.github.createtechified.evolutioncore;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import io.github.createtechified.evolutioncore.common.registry.ModToolTiers;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("unused")
public class Reference {
    public static final String MODID = "evolutioncore";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final GTRegistrate REGISTRATE = GTRegistrate.create(Reference.MODID);
    public static final Tier[] TIERS = { Tiers.WOOD, Tiers.STONE, ModToolTiers.COPPER, Tiers.IRON, ModToolTiers.BRONZE, Tiers.DIAMOND, ModToolTiers.UNSTABLE, Tiers.NETHERITE, ModToolTiers.getGTNeutroniumTier() };
}
