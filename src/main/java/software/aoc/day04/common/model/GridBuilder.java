package software.aoc.day04.common.model;

import java.util.ArrayList;
import java.util.List;

public class GridBuilder {
    private int rows;
    private int columns;
    private List<List<Cell>> cells;

    public GridBuilder() {
        rows = 1;
        columns = 1;
        cells = new ArrayList<>();
    }

    public GridBuilder rows(int rows) {
        this.rows = rows;
        return this;
    }

    public GridBuilder columns(int columns) {
        this.columns = columns;
        return this;
    }

    public GridBuilder cells(List<List<Cell>> cells) {
        this.cells = cells;
        return this;
    }

    public Grid build() {
        Grid grid = new Grid(rows, columns);
        int x  = 0;
        for (List<Cell> row : cells) {
            int y = 0;
            for (Cell cell : row) {
                grid.set(x, y, cell);
                y++;
            }
            x++;
        }
        return grid;
    }
}
