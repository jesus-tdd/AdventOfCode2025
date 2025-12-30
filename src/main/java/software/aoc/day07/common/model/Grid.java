package software.aoc.day07.common.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static software.aoc.day07.common.model.Cell.State.*;

public class Grid {
    private final Map<Position, Cell> grid;
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
        grid.put(new Position(row, column), cell);
    }

    public Cell get(int row, int column) {
        if (isNotInBounds(row, column)) throw new IndexOutOfBoundsException();
        return grid.get(new Position(row, column));
    }

    public void setIfInBounds(int row, int column, Cell cell) {
        if (isNotInBounds(row, column)) return;
        grid.put(new Position(row, column), cell);
    }

    public boolean isInBounds(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean isNotInBounds(int row, int column) {
        return !isInBounds(row, column);
    }

    public int getActiveSplitters() {
        return Math.toIntExact(
                grid.keySet().stream()
                .filter(p -> grid.get(p).state() == Splitter && this.get(p.row - 1, p.column).state() == TachyonBeam)
                .count()
        );
    }

    public Position getStartingPosition() {
        return this.grid.keySet().stream().filter(p -> grid.get(p).state() == Start).toList().getFirst();
    }

    public boolean rowContains(int rowIndex, Cell.State state) {
        List<Position> row = grid.keySet().stream().filter(p -> p.row == rowIndex).toList();
        for (Position position : row) {
            if (grid.get(position).state() == state) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                builder.append(this.get(i, j));
            }
            builder.append("\n");
        }
        builder.append("\n");

        return builder.toString();
    }

    public record Position(int row, int column) { }
}
