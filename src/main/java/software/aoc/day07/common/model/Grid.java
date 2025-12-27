package software.aoc.day07.common.model;

import java.util.HashMap;
import java.util.Map;

import static software.aoc.day07.common.model.Cell.State.Splitter;
import static software.aoc.day07.common.model.Cell.State.TachyonBeam;

public class Grid {
    private final Map<Coordinate, Cell> grid;
    private final int rows;
    private final int columns;

    public Grid(int rows, int columns) {
        grid = new HashMap<>();
        this.rows = rows;
        this.columns = columns;
    }

    public int rows() {
        return rows;
    }

    public int columns() {
        return columns;
    }

    public void set(int row, int column, Cell cell) {
        if (isNotInBounds(row, column)) throw new IndexOutOfBoundsException();
        grid.put(new Coordinate(row, column), cell);
    }

    public Cell get(int row, int column) {
        if (isNotInBounds(row, column)) throw new IndexOutOfBoundsException();
        return grid.get(new Coordinate(row, column));
    }

    public void setIfInBounds(int row, int column, Cell cell) {
        if (isNotInBounds(row, column)) return;
        grid.put(new Coordinate(row, column), cell);
    }

    public boolean isNotInBounds(int row, int column) {
        return row < 0 || row >= rows || column < 0 || column >= columns;
    }

    public long getActiveSplitters() {
        return grid.keySet().stream()
                .filter(c -> grid.get(c).state() == Splitter && this.get(c.x-1, c.y).state() == TachyonBeam)
                .count();
    }

    public Grid copy() {
        Grid newGrid = new Grid(rows, columns);
        for (Coordinate coordinate : this.grid.keySet()) {
            newGrid.grid.put(coordinate, this.grid.get(coordinate));
        }
        return newGrid;
    }

    private record Coordinate (int x, int y) { }
 }
