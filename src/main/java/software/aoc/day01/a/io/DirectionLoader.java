package software.aoc.day01.a.io;

import software.aoc.day01.a.model.Rotation.Direction;

import java.util.List;

public interface DirectionLoader {
    List<Direction> loadAll();
}
