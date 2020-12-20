package com.chrosciu.lotto;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Utils {

    public static Boolean[][] calculateIntersections(List<Set<Integer>> draws) {
        int size = draws.size();
        Boolean[][] intersections = new Boolean[size][size];
        for (int i = 0; i < size; ++i) {
            Set<Integer> firstDraw = draws.get(i);
            for (int j = i; j < size; ++j) {
                Set<Integer> secondDraw = draws.get(j);
                Set<Integer> secondDrawCopy = new HashSet<>(secondDraw);
                secondDrawCopy.retainAll(firstDraw);
                boolean intersection = !secondDrawCopy.isEmpty();
                intersections[i][j] = intersection;
            }
        }
        return intersections;
    }

    public static List<List<Integer>> extendRow(List<Integer> row, Boolean[][] intersections) {
        List<List<Integer>> extendedRows = new LinkedList<>();
        int lastInRow = row.get(row.size() - 1);
        int drawsCount = intersections.length;
        for (int candidate = lastInRow + 1; candidate < drawsCount; ++candidate) {
            boolean acceptable = true;
            for (int element: row) {
                boolean intersection = intersections[element][candidate];
                if (intersection) {
                    acceptable = false;
                    break;
                }
            }
            if (acceptable) {
                List<Integer> extendedRow = new LinkedList<>(row);
                extendedRow.add(candidate);
                extendedRows.add(extendedRow);
            }
        }
        return extendedRows;
    }
}
