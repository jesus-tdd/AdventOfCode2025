package software.aoc.day07.common.io;

import software.aoc.common.io.InputParser;
import software.aoc.day07.common.model.Cell;

import java.util.Arrays;
import java.util.List;

public class CellListParser implements InputParser<List<Cell>> {
    @Override
    public List<Cell> parse(String string) {
        return Arrays.stream(string.split("")).map(this::toCell).toList();
    }

    private Cell toCell(String string) {
        if (string.equals("S")) return Cell.Start();
        if (string.equals("^")) return Cell.Splitter();
        if (string.equals("|")) return Cell.TachyonBeam();
        return Cell.Empty();
    }
}
