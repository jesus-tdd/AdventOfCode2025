package software.aoc.day07.common.services;

import software.aoc.day07.common.model.Cell;
import software.aoc.day07.common.model.Grid;

import java.util.ArrayList;
import java.util.List;

import static software.aoc.day07.common.model.Cell.State.*;
import static software.aoc.day07.common.model.Cell.State.Splitter;
import static software.aoc.day07.common.model.Cell.State.TachyonBeam;

public class QuantumGridSimulator implements Simulator<List<Grid>> {
    private final List<Grid> timelines;

    public QuantumGridSimulator(Grid grid) {
        timelines = new ArrayList<>();
        timelines.add(grid);
    }

    private void startTachyonBeamIfMust(Grid grid, int i, int j) {
        if (grid.get(i, j).state() != Start) return;

        grid.setIfInBounds(i+1, j, Cell.TachyonBeam());
    }

    private void extendTachyonBeamIfMust(Grid grid, int i, int j) {
        if (grid.get(i, j).state() != TachyonBeam) return;
        if (grid.isNotInBounds(i +1, j)) return;
        if (grid.get(i +1, j).state() == Splitter) return;

        grid.setIfInBounds(i +1, j, Cell.TachyonBeam());
    }

    private Grid splitTachyonBeamIfMust(Grid grid, int i, int j) {
        if (grid.get(i, j).state() != Splitter) return null;
        if (grid.get(i -1, j).state() != TachyonBeam) return null;

        Grid newGrid = grid.copy();
        grid.setIfInBounds(i, j -1, Cell.TachyonBeam());
        newGrid.setIfInBounds(i, j +1, Cell.TachyonBeam());
        return newGrid;
    }

    @Override
    public List<Grid> step() {
        List<Grid> newTimelines = new ArrayList<>();
        for (Grid timeline : timelines) {
            newTimelines = stepTimeline(timeline);
        }
        timelines.addAll(newTimelines);
        return timelines;
    }

    private List<Grid> stepTimeline(Grid timeline) {
        List<Grid> newTimelines = new ArrayList<>();
        for (int i = 0; i < timeline.rows(); i++) {
            for (int j = 0; j < timeline.columns(); j++) {
                startTachyonBeamIfMust(timeline, i, j);
                extendTachyonBeamIfMust(timeline, i, j);
                Grid newTimeline = splitTachyonBeamIfMust(timeline, i, j);
                if (newTimeline != null) newTimelines.add(newTimeline);
            }
        }
        return newTimelines;
    }

    @Override
    public List<Grid> simulate() {
        for (int i = 0; i < timelines.getFirst().rows(); i++) {
            this.step();
        }
        return timelines;
    }
}
