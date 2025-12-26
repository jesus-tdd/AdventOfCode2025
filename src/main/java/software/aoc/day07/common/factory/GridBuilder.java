package software.aoc.day07.common.factory;

import software.aoc.day07.common.model.Cell;
import software.aoc.day07.common.model.Grid;

import java.util.ArrayList;
import java.util.List;

public class GridBuilder {
    private List<List<Cell>> cells;
    private int rows;
    private int columns;

    public GridBuilder() {
        cells = new ArrayList<>();
        rows = 0;
        columns = 0;
    }

    public GridBuilder cells(List<List<Cell>> cells) {
        this.cells = cells;
        return this;
    }

    public GridBuilder rows(int rows) {
        this.rows = rows;
        return this;
    }

    public GridBuilder columns(int columns) {
        this.columns = columns;
        return this;
    }

    public Grid build() {
        Grid grid = new Grid(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid.set(i, j, cells.get(i).get(j));
            }
        }
        return grid;
    }
}
