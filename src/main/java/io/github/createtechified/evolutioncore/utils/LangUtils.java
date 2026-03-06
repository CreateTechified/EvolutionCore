package io.github.createtechified.evolutioncore.utils;

import org.apache.commons.lang3.text.WordUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LangUtils {
    public static String circuitName(String id) {
        String[] parts = id.split("_");
        String type = WordUtils.capitalizeFully(parts[2]);
        String tier = parts[3];
        String tierF = switch (tier) {
            case "luv" -> "LuV";
            case "opv" -> "OpV";
            default -> tier.toUpperCase();
        };

        return String.format("%s Universal Circuit (%s)", type, tierF);
    }

    public static String regularName(String id) {
        return Arrays.stream(id.split("_")).map(s -> s.substring(0,1).toUpperCase() + s.substring(1)).collect(Collectors.joining(" "));
    }
}
