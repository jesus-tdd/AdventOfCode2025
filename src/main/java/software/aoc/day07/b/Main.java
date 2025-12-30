package software.aoc.day07.b;

import software.aoc.day07.common.factory.GridBuilder;
import software.aoc.day07.common.io.CellListLoader;
import software.aoc.day07.common.io.CellListParser;
import software.aoc.day07.common.model.Cell;
import software.aoc.day07.common.model.Grid;
import software.aoc.day07.common.services.QuantumGridSimulator;

import java.util.List;

public class Main {
    static void main() {
        List<List<Cell>> cells = new CellListLoader(new CellListParser()::parse).loadAll();
        long timelines = new QuantumGridSimulator(getGrid(cells)).simulate().countTimelines();
        System.out.println("Total timelines: " + timelines);
    }

    private static Grid getGrid(List<List<Cell>> cells) {
        return new GridBuilder()
                .rows(cells.size())
                .columns(cells.getFirst().size())
                .cells(cells)
                .build();
    }
}
