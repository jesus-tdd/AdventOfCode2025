package software.aoc.day01.a.model;

public record Rotation(Direction direction, int value) {
    public enum Direction {
        L, R
    }
}
