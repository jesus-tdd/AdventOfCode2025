package software.aoc.day07.common.model;

public record Cell (State state) {
    public enum State {
        Empty, TachyonBeam, Splitter, Start
    }

    public static Cell Empty() {
        return new Cell(State.Empty);
    }

    public static Cell TachyonBeam() {
        return new Cell(State.TachyonBeam);
    }

    public static Cell Splitter() {
        return new Cell(State.Splitter);
    }

    public static Cell Start() {
        return new Cell(State.Start);
    }
}
