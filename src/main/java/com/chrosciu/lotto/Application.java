package com.chrosciu.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Range of draws is needed");
        }
        int from;
        int to;
        try {
            from = Integer.parseInt(args[0]);
            to = Integer.parseInt(args[1]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Range must be integer numbers");
        }
        if (from < 0 || from > to || to > 6507) {
            throw new IllegalArgumentException("Range must be correct (0 <= from <= to <= 6507)");
        }

        List<Set<Integer>> allDraws = Loader.readDrawsFromFile();
        List<Set<Integer>> draws = allDraws.subList(from, to);

        Boolean[][] intersections = Utils.calculateIntersections(draws);

        int maxRowSize = 1;
        List<List<Integer>> rows = IntStream
                .range(0, draws.size())
                .mapToObj(Arrays::asList).collect(Collectors.toList());

        while (true) {
            List<List<Integer>> extendedRows = rows.stream()
                    .flatMap(row -> Utils.extendRow(row, intersections).stream())
                    .collect(Collectors.toList());
            System.out.printf("Extending %d rows of size %d -> obtained %d rows of size %d\n", rows.size(), maxRowSize, extendedRows.size(), maxRowSize + 1);
            if (extendedRows.isEmpty()) {
                break;
            }
            rows = extendedRows;
            ++maxRowSize;
        }

        System.out.printf("Maximum size of rows without intersection: %d\n", maxRowSize);
        System.out.printf("Rows: %s\n", rows);
    }
}
