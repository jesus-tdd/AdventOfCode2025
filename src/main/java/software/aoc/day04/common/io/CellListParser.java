package software.aoc.day04.common.io;

import software.aoc.day04.common.model.Cell;

import java.util.ArrayList;
import java.util.List;

import static software.aoc.day04.common.model.Cell.Status.Empty;
import static software.aoc.day04.common.model.Cell.Status.Roll;

public class CellListParser {
    public static List<Cell> parse(String line) {
        return parse(line.split(""));
    }

    private static List<Cell> parse(String[] split) {
        List<Cell> cells = new ArrayList<>();
        for (String s : split) {
            cells.add(toCell(s));
        }
        return cells;
    }

    private static Cell toCell(String s) {
        return s.equals("@") ? new Cell(Roll) : new Cell(Empty);
    }
}
