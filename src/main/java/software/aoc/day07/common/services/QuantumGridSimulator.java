package software.aoc.day07.common.services;

import software.aoc.day07.common.model.Grid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static software.aoc.day07.common.model.Cell.State.Splitter;

public class QuantumGridSimulator implements Simulator{
    private final Grid grid;
    private final Map<BeamState, Long> beamStates;

    public QuantumGridSimulator(Grid grid) {
        this.grid = grid;
        this.beamStates = new HashMap<>();
        beamStates.put(getFirstBeamState(grid), 1L);
    }

    private static BeamState getFirstBeamState(Grid grid) {
        return new BeamState(
                grid.getStartingPosition().row(),
                grid.getStartingPosition().column()
        );
    }

    @Override
    public QuantumGridSimulator step() {
        Map<BeamState, Long> nextBeamStates = new HashMap<>();
        for (BeamState state : beamStates.keySet()) {
            for (BeamState nextState : getNextBeamState(state)) {
                nextBeamStates.merge(nextState, beamStates.get(state), Long::sum);
            }
        }
        updateBeamStates(nextBeamStates);
        return this;
    }

    private List<BeamState> getNextBeamState(BeamState state) {
        if (state.row + 1 == grid.rows()) return List.of(state);

        return grid.get(state.row, state.column).state() == Splitter
                ? List.of(new BeamState(state.row, state.column+1), new BeamState(state.row+1, state.column-1))
                : List.of(new BeamState(state.row+1, state.column()));
    }

    private void updateBeamStates(Map<BeamState, Long> nextBeamStates) {
        beamStates.clear();
        for (BeamState state : nextBeamStates.keySet()) {
            beamStates.put(state, nextBeamStates.get(state));
        }
    }

    @Override
    public QuantumGridSimulator simulate() {
        beamStates.clear();
        beamStates.put(getFirstBeamState(grid), 1L);
        while (canContinue()) {
            this.step();
        }
        return this;
    }

    private boolean canContinue() {
        for (BeamState state : beamStates.keySet()) {
            if (state.row + 1 < grid.rows()) return true;
        }
        return false;
    }

    public long countTimelines() {
        return beamStates.keySet().stream()
                .map(beamStates::get)
                .reduce(0L, Long::sum);
    }

    private record BeamState(int row, int column) { }
}
