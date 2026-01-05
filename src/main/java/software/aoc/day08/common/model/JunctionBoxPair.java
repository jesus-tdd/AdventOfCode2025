package software.aoc.day08.common.model;

public record JunctionBoxPair(JunctionBox box1, JunctionBox box2) {
    public long distanceSquared() {
        return xDistance() * xDistance() +
               yDistance() * yDistance() +
               zDistance() * zDistance();
    }

    private long xDistance() {
        return Math.abs(box1.x() - box2.x());
    }

    private long yDistance() {
        return Math.abs(box1.y() - box2.y());
    }

    private long zDistance() {
        return Math.abs(box1.z() - box2.z());
    }
}
