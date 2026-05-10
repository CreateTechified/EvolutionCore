package io.github.createtechified.evolutioncore;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("unused")
public class Reference {
    public static final String MODID = "evolutioncore";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final GTRegistrate REGISTRATE = GTRegistrate.create(Reference.MODID);
}
