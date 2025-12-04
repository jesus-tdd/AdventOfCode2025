package software.aoc.day01.a.model;

import static software.aoc.day01.a.model.Rotation.Direction.L;

public class Dial {
    private final int from;
    private final int to;
    private final int pointingAt;


    public Dial(int from, int to, int pointingAt) {
        this.from = from;
        this.to = to;
        this.pointingAt = pointingAt;
    }

    public int pointingAt() {
        return pointingAt;
    }

    public Dial rotate(Rotation rotation) {
        return rotation.direction() == L? this.rotateLeft(rotation.value()) : this.rotateRight(rotation.value()) ;
    }

    private Dial rotateLeft(int value) {
        return new Dial(0, 99, (this.size() + this.pointingAt() - value) % this.size());
    }

    private Dial rotateRight(int value) {
        return new Dial(0, 99, (this.pointingAt() + value) % this.size());
    }

    private int size() {
        return this.to - this.from  + 1;
    }

}
