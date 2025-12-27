package software.aoc.day07.common.services;

import software.aoc.day07.common.model.Grid;

public interface Simulator<T> {
    public T step();
    public T simulate();
}
