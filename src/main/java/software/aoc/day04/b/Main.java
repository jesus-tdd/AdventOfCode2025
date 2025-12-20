package software.aoc.day04.b;

import software.aoc.day04.common.io.CellListLoader;
import software.aoc.day04.common.io.CellListParser;
import software.aoc.day04.common.model.Cell;
import software.aoc.day04.common.model.Grid;
import software.aoc.day04.common.model.GridBuilder;

import java.util.List;

import static software.aoc.day04.common.model.Cell.Status.Roll;

public class Main {
    static void main() {
        Grid grid = getGrid();
        long total = 0;
        while(getAccessibleRolls(grid) > 0) {
            total += getAccessibleRolls(grid);
            grid.stream()
                    .filter(c -> grid.get(c.x(), c.y()).status() == Roll)
                    .filter(c -> grid.countRollsAdjacentTo(c.x(), c.y()) < 4)
                    .toList()
                    .forEach(c -> grid.removeRollFrom(c.x(), c.y()));
        }

        System.out.println(total);
    }

    private static long getAccessibleRolls(Grid grid) {
        return grid.stream()
                .filter(c -> grid.get(c.x(), c.y()).status() == Roll)
                .map(c -> grid.countRollsAdjacentTo(c.x(), c.y()))
                .filter(n -> n < 4)
                .count();
    }

    private static Grid getGrid() {
        List<List<Cell>> cellLists = new CellListLoader(CellListParser::parse).loadAll();
        return new GridBuilder()
                .rows(cellLists.getFirst().size())
                .columns(cellLists.size())
                .cells(cellLists)
                .build();
    }
}
