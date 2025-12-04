package software.aoc.day01.common.model;

import static software.aoc.day01.common.model.Rotation.Direction.L;

public class Dial {
    private final int from;
    private final int to;
    private final int value;

    public Dial(int from, int to, int value) {
        this.from = from;
        this.to = to;
        this.value = value;
    }

    public int value() {
        return value;
    }

    public boolean isPointingAt(int value) {
        return this.value == value;
    }

    public Dial rotate(Rotation rotation) {
        return rotation.direction() == L? this.rotateLeft(rotation.value()) : this.rotateRight(rotation.value()) ;
    }

    private Dial rotateLeft(int value) {
        return new Dial(0, 99, (this.size() + this.value() - value) % this.size());
    }

    private Dial rotateRight(int value) {
        return new Dial(0, 99, (this.value() + value) % this.size());
    }

    private int size() {
        return this.to - this.from  + 1;
    }

}
