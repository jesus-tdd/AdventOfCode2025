package software.aoc.day07.common.io;

import software.aoc.day07.common.model.Cell;

import java.util.Arrays;
import java.util.List;

public class CellListParser {
    public static List<Cell> parse(String string) {
        return Arrays.stream(string.split("")).map(CellListParser::toCell).toList();
    }

    private static Cell toCell(String string) {
        if (string.equals("S")) return Cell.Start();
        if (string.equals("^")) return Cell.Splitter();
        if (string.equals("|")) return Cell.TachyonBeam();
        return Cell.Empty();
    }
}
