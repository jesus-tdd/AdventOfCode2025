package software.aoc.day01.a.io;

import software.aoc.day01.a.model.Rotation;

import java.util.stream.Stream;

public interface RotationLoader {
    Stream<Rotation> loadAll();
}
