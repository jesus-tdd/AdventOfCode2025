package software.aoc.day07.a;

import software.aoc.day07.common.io.CellListLoader;
import software.aoc.day07.common.io.CellListParser;
import software.aoc.day07.common.model.Cell;
import software.aoc.day07.common.model.Grid;
import software.aoc.day07.common.factory.GridBuilder;
import software.aoc.day07.common.services.GridSimulator;

import java.util.List;

public class Main {
    static void main() {
        List<List<Cell>> cells = new CellListLoader(CellListParser::parse).loadAll();
        Grid grid = new GridSimulator(getGrid(cells)).simulate().grid();
        System.out.println("Total splits: " + grid.getActiveSplitters());
    }

    private static Grid getGrid(List<List<Cell>> cells) {
        return new GridBuilder()
                .rows(cells.size())
                .columns(cells.getFirst().size())
                .cells(cells)
                .build();
    }
}
