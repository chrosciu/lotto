package com.chrosciu.lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class Application {
    private static final List<Set<Integer>> DRAWS = asList(
            new HashSet<>(asList(2, 6, 7, 25, 28, 33)),
            new HashSet<>(asList(2, 5, 9, 16, 22, 42)),
            new HashSet<>(asList(8, 18, 20, 29, 34, 40)),
            new HashSet<>(asList(19, 25, 29, 37, 41, 48)),
            new HashSet<>(asList(1, 8, 17, 21, 38, 40)),
            new HashSet<>(asList(4, 18, 24, 30, 35, 36)),
            new HashSet<>(asList(12, 18, 20, 21, 29, 36)),
            new HashSet<>(asList(2, 33, 35, 36, 37, 43)),
            new HashSet<>(asList(5, 13, 22, 29, 31, 42)),
            new HashSet<>(asList(10, 13, 25, 43, 45, 47)),
            new HashSet<>(asList(7, 15, 34, 37, 40, 45)),
            new HashSet<>(asList(1, 3, 21, 41, 43, 45)),
            new HashSet<>(asList(11, 17, 22, 34, 35, 40)),
            new HashSet<>(asList(12, 17, 21, 34, 38, 47)),
            new HashSet<>(asList(2, 5, 11, 25, 31, 45)),
            new HashSet<>(asList(17, 18, 19, 23, 28, 29)),
            new HashSet<>(asList(8, 20, 21, 44, 48, 49)),
            new HashSet<>(asList(13, 15, 20, 29, 31, 35)),
            new HashSet<>(asList(4, 19, 24, 28, 32, 33)),
            new HashSet<>(asList(3, 13, 19, 21, 37, 44)),
            new HashSet<>(asList(1, 30, 31, 35, 41, 42)),
            new HashSet<>(asList(3, 17, 25, 32, 33, 37)),
            new HashSet<>(asList(19, 26, 27, 30, 36, 40)),
            new HashSet<>(asList(10, 13, 26, 27, 30, 36)),
            new HashSet<>(asList(5, 9, 11, 13, 20, 26)),
            new HashSet<>(asList(3, 6, 15, 31, 37, 40)),
            new HashSet<>(asList(2, 6, 8, 22, 36, 44)),
            new HashSet<>(asList(3, 15, 16, 19, 36, 47)),
            new HashSet<>(asList(7, 10, 13, 14, 38, 43)),
            new HashSet<>(asList(5, 10, 19, 37, 40, 48)),
            new HashSet<>(asList(4, 10, 14, 22, 40, 47)),
            new HashSet<>(asList(6, 18, 22, 26, 30, 38)),
            new HashSet<>(asList(8, 15, 17, 32, 40, 46)),
            new HashSet<>(asList(7, 26, 30, 36, 41, 45)),
            new HashSet<>(asList(12, 13, 20, 30, 34, 37)),
            new HashSet<>(asList(9, 18, 19, 20, 24, 41)),
            new HashSet<>(asList(5, 12, 13, 39, 41, 46)),
            new HashSet<>(asList(9, 11, 19, 25, 27, 43)),
            new HashSet<>(asList(3, 29, 30, 34, 38, 43)),
            new HashSet<>(asList(3, 21, 27, 28, 46, 49)),
            new HashSet<>(asList(4, 8, 9, 13, 16, 21)),
            new HashSet<>(asList(2, 22, 30, 31, 34, 43)),
            new HashSet<>(asList(1, 8, 13, 18, 34, 41)),
            new HashSet<>(asList(16, 20, 32, 33, 43, 46)),
            new HashSet<>(asList(5, 24, 31, 36, 39, 48)),
            new HashSet<>(asList(7, 8, 16, 37, 45, 47)),
            new HashSet<>(asList(2, 4, 26, 27, 32, 48)),
            new HashSet<>(asList(3, 26, 29, 45, 46, 48)),
            new HashSet<>(asList(8, 10, 11, 23, 24, 44)),
            new HashSet<>(asList(7, 9, 16, 19, 40, 46)),
            new HashSet<>(asList(2, 3, 9, 16, 44, 47)),
            new HashSet<>(asList(28, 35, 37, 43, 47, 49)),
            new HashSet<>(asList(1, 11, 15, 33, 38, 49)),
            new HashSet<>(asList(5, 8, 18, 22, 47, 48)),
            new HashSet<>(asList(2, 4, 8, 23, 24, 40)),
            new HashSet<>(asList(2, 5, 7, 12, 31, 45)),
            new HashSet<>(asList(19, 22, 25, 32, 40, 46)),
            new HashSet<>(asList(2, 19, 29, 35, 37, 48)),
            new HashSet<>(asList(7, 9, 13, 27, 31, 43)),
            new HashSet<>(asList(13, 16, 26, 29, 37, 42)),
            new HashSet<>(asList(9, 11, 21, 28, 31, 34)),
            new HashSet<>(asList(17, 23, 33, 38, 47, 49)),
            new HashSet<>(asList(14, 21, 30, 34, 40, 48)),
            new HashSet<>(asList(4, 18, 21, 22, 28, 44)),
            new HashSet<>(asList(5, 10, 12, 14, 32, 35)),
            new HashSet<>(asList(3, 7, 21, 22, 38, 49)),
            new HashSet<>(asList(13, 14, 25, 44, 45, 47)),
            new HashSet<>(asList(2, 3, 8, 17, 29, 33)),
            new HashSet<>(asList(1, 2, 6, 7, 13, 17)),
            new HashSet<>(asList(4, 9, 16, 29, 35, 45)),
            new HashSet<>(asList(3, 4, 21, 22, 34, 41)),
            new HashSet<>(asList(10, 11, 24, 26, 41, 45)),
            new HashSet<>(asList(13, 23, 24, 34, 39, 42)),
            new HashSet<>(asList(3, 6, 14, 30, 32, 44)),
            new HashSet<>(asList(16, 27, 28, 33, 34, 45)),
            new HashSet<>(asList(1, 10, 14, 23, 28, 48)),
            new HashSet<>(asList(14, 25, 35, 41, 42, 47)),
            new HashSet<>(asList(16, 26, 36, 41, 44, 48)),
            new HashSet<>(asList(7, 15, 17, 27, 32, 42)),
            new HashSet<>(asList(14, 18, 19, 23, 37, 39)),
            new HashSet<>(asList(18, 21, 24, 31, 36, 45)),
            new HashSet<>(asList(14, 29, 32, 37, 40, 41)),
            new HashSet<>(asList(2, 15, 20, 23, 30, 37)),
            new HashSet<>(asList(9, 14, 26, 27, 39, 46)),
            new HashSet<>(asList(2, 12, 13, 30, 42, 47)),
            new HashSet<>(asList(6, 10, 13, 14, 38, 49)),
            new HashSet<>(asList(1, 19, 23, 39, 45, 46)),
            new HashSet<>(asList(6, 12, 13, 37, 39, 40)),
            new HashSet<>(asList(5, 18, 28, 32, 42, 43)),
            new HashSet<>(asList(1, 4, 5, 15, 28, 49)),
            new HashSet<>(asList(1, 9, 15, 24, 30, 44)),
            new HashSet<>(asList(2, 7, 14, 17, 21, 41)),
            new HashSet<>(asList(7, 13, 17, 21, 28, 33)),
            new HashSet<>(asList(3, 9, 15, 35, 36, 38)),
            new HashSet<>(asList(7, 11, 13, 27, 36, 40)),
            new HashSet<>(asList(9, 25, 30, 31, 36, 48)),
            new HashSet<>(asList(8, 11, 28, 33, 40, 49)),
            new HashSet<>(asList(5, 15, 29, 34, 44, 47)),
            new HashSet<>(asList(8, 24, 27, 32, 44, 47)),
            new HashSet<>(asList(14, 19, 24, 25, 26, 37))
    );

    public static void main(String[] args) {
        Boolean[][] intersections = Utils.calculateIntersections(DRAWS);

        int maxRowSize = 1;
        List<List<Integer>> rows = IntStream
                .range(0, DRAWS.size())
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
