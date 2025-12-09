package software.aoc.day04.common.model;

import java.util.*;
import java.util.stream.Stream;

import static software.aoc.day04.common.model.Cell.Status.Roll;

public class Grid {
    private final int rows;
    private final int columns;
    private final Map<Coordinate, Cell> values;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        values = new HashMap<>();
    }

    public int rows() {
        return rows;
    }

    public int columns() {
        return columns;
    }

    public Cell get(int x, int y) {
        if (x < 0 || y < 0 || x >= rows || y >= rows) throw new IndexOutOfBoundsException("");
        return this.values.get(new Coordinate(x, y));
    }

    public void set(int x, int y, Cell cell) {
        if (x < 0 || y < 0 || x >= rows || y >= rows) throw new IndexOutOfBoundsException();
        values.put(new Coordinate(x, y), cell);
    }

    public int countRollsAdjacentTo(int x, int y) {
        List<Cell> list = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if(i == 0 && j == 0) continue;
                if(!this.exists(x+i, y+j)) continue;
                list.add(this.get(x+i, y+j));
            }
        }
        return (int) list.stream().filter(c -> c.status() == Roll).count();
    }

    private boolean exists(int x, int y) {
        return x >= 0
            && y >= 0
            && x < rows
            && y < columns
            && this.get(x, y) != null;
    }

    public Stream<Coordinate> stream() {
        return values.keySet().stream();
    }

    public record Coordinate (int x, int y) { }
}
