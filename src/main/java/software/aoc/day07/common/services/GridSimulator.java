package software.aoc.day07.common.services;

import software.aoc.day07.common.model.Cell;
import software.aoc.day07.common.model.Grid;

import static software.aoc.day07.common.model.Cell.State.*;

public class GridSimulator implements Simulator<Grid> {
    private final Grid grid;

    public GridSimulator(Grid grid) {
        this.grid = grid;
    }

    private void startTachyonBeamIfMust(int i, int j) {
        if (grid.get(i, j).state() != Start) return;

        grid.setIfInBounds(i+1, j, Cell.TachyonBeam());
    }

    private void extendTachyonBeamIfMust(int i, int j) {
        if (grid.get(i, j).state() != TachyonBeam) return;
        if (grid.isNotInBounds(i +1, j)) return;
        if (grid.get(i +1, j).state() == Splitter) return;

        grid.setIfInBounds(i +1, j, Cell.TachyonBeam());
    }

    private void splitTachyonBeamIfMust(int i, int j) {
        if (grid.get(i, j).state() != Splitter) return;
        if (grid.get(i -1, j).state() != TachyonBeam) return;

        grid.setIfInBounds(i, j -1, Cell.TachyonBeam());
        grid.setIfInBounds(i, j +1, Cell.TachyonBeam());
    }

    @Override
    public Grid step() {
        for (int i = 0; i < grid.rows(); i++) {
            for (int j = 0; j < grid.columns(); j++) {
                startTachyonBeamIfMust(i, j);
                extendTachyonBeamIfMust(i, j);
                splitTachyonBeamIfMust(i, j);
            }
        }
        return grid;
    }

    @Override
    public Grid simulate() {
        for (int i = 0; i < grid.rows(); i++) {
            this.step();
        }
        return grid;
    }
}
