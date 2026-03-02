package io.github.createtechified.evolutioncore.utils;

import org.apache.commons.lang3.text.WordUtils;

public class LangUtils {
    public static String circuitName(String id) {
        String[] parts = id.split("_");
        String type = WordUtils.capitalizeFully(parts[2]);
        String tier = parts[3];
        String tierF;

        switch (tier) {
            case "luv":
                tierF = "LuV";
                break;
            case "opv":
                tierF = "OpV";
                break;
            default:
                tierF = tier.toUpperCase();
                break;
        }

        return String.format("%s Universal Circuit (%s)", type, tierF);
    }
}
