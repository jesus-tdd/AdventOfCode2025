package software.aoc.day07.common.services;

import software.aoc.day07.common.model.Cell;
import software.aoc.day07.common.model.Grid;

import static software.aoc.day07.common.model.Cell.State.*;

public class GridSimulator implements Simulator {
    private final Grid grid;

    public GridSimulator(Grid grid) {
        this.grid = grid;
    }

    private void startTachyonBeamIfMust(int i, int j) {
        if (grid.isNotInBounds(i, j)) return;
        if (grid.get(i, j).state() != Start) return;

        grid.setIfInBounds(i+1, j, Cell.TachyonBeam());
    }

    private void extendTachyonBeamIfMust(int i, int j) {
        if (grid.isNotInBounds(i, j)) return;
        if (grid.get(i, j).state() != TachyonBeam) return;
        if (grid.isNotInBounds(i +1, j)) return;
        if (grid.get(i +1, j).state() == Splitter) return;

        grid.setIfInBounds(i +1, j, Cell.TachyonBeam());
    }

    private void splitTachyonBeamIfMust(int i, int j) {
        if (grid.isNotInBounds(i, j)) return;
        if (grid.get(i, j).state() != Splitter) return;
        if (grid.get(i -1, j).state() != TachyonBeam) return;

        grid.setIfInBounds(i, j-1, Cell.TachyonBeam());
        grid.setIfInBounds(i, j+1, Cell.TachyonBeam());
    }

    @Override
    public GridSimulator step() {
        int row = getNextRowIndex();

        for (int column = 0; column < grid.columns(); column++) {
            startTachyonBeamIfMust(row, column);
            extendTachyonBeamIfMust(row, column);
            splitTachyonBeamIfMust(row+1, column);
        }
        return this;
    }

    private int getNextRowIndex() {
        int row;
        for (row = 0; row < grid.rows(); row++) {
            if (grid.isInBounds(row+1,0) && !grid.rowContains(row+1, TachyonBeam)) {
                System.out.println(row);
                return row;
            }
        }
        return row;
    }

    @Override
    public GridSimulator simulate() {
        for (int i = 0; i < grid.rows(); i++) {
            this.step();
        }
        return this;
    }

    public Grid grid() {
        return grid;
    }
}
