package software.aoc.day01.a.model;

import static software.aoc.day01.a.model.Rotation.Direction.L;

public class Dial {
    private final int pointingAt;


    public Dial(int value) {
        this.pointingAt = value;
    }

    public int pointingAt() {
        return pointingAt;
    }

    public Dial rotate(Rotation rotation) {
        return rotation.direction() == L? this.rotateLeft(rotation.value()) : this.rotateRight(rotation.value()) ;
    }

    private Dial rotateLeft(int value) {
        return new Dial((100 + this.pointingAt() - value) % 100);
    }

    private Dial rotateRight(int value) {
        return new Dial((this.pointingAt() + value) % 100);
    }

}
