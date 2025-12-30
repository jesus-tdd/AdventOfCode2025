package software.aoc.day07.common.services;

import software.aoc.day07.common.model.Grid;

public interface Simulator {
    public Simulator step();
    public Simulator simulate();
}
