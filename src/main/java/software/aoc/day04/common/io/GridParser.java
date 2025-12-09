package software.aoc.day04.common.io;

import software.aoc.day04.common.model.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static software.aoc.day04.common.model.Cell.Status.Empty;
import static software.aoc.day04.common.model.Cell.Status.Roll;

public class GridParser {
    public static Stream<List<Cell>> parse(String line) {
        return parse(line.split(""));
    }

    private static Stream<List<Cell>> parse(String[] split) {
        List<Cell> cells = new ArrayList<>();
        for (String s : split) {
            cells.add(toCell(s));
        }
        return Stream.of(cells);
    }

    private static Cell toCell(String s) {
        return s.equals("@") ? new Cell(Roll) : new Cell(Empty);
    }
}
