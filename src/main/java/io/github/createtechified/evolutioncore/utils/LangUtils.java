package io.github.createtechified.evolutioncore.utils;

import org.apache.commons.lang3.text.WordUtils;

public class LangUtils {
    public static String circuitName(String id) {
        String[] parts = id.split("_");
        String type = WordUtils.capitalizeFully(parts[2]);
        String tier = parts[3].toUpperCase();
        return String.format("%s Universal Circuit (%s)", type, tier);
    }
}
