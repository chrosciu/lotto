package com.chrosciu.lotto;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Loader {
    private static Pattern DRAW = Pattern.compile("[0-9]*\\.\\s[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}\\s([0-9]+),([0-9]+),([0-9]+),([0-9]+),([0-9]+),([0-9]+)");

    public static Set<Integer> parseDrawLine(String drawLine) {
        Matcher matcher = DRAW.matcher(drawLine);
        Set<Integer> result = new TreeSet<>();
        if (matcher.find()) {
            int groupCount = matcher.groupCount();
            for (int i = 1; i <= groupCount; ++i) {
                result.add(Integer.parseInt(matcher.group(i)));
            }
            return result;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static List<String> readDrawLinesFromFile() {
        try (InputStream resource = Loader.class.getResourceAsStream("/draws.txt")) {
            return new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8))
                    .lines().collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Set<Integer>> readDrawsFromFile() {
        return readDrawLinesFromFile().stream().map(Loader::parseDrawLine).collect(Collectors.toList());
    }
}
