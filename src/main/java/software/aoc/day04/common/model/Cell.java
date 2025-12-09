package software.aoc.day04.common.model;

public record Cell (Status status) {
    public enum Status {
        Roll, Empty
    }
}
