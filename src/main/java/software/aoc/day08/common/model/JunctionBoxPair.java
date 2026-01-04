package software.aoc.day08.common.model;

public record JunctionBoxPair(JunctionBox box1, JunctionBox box2) {
    public double distance() {
        return Math.sqrt(
                getXDistance() * getXDistance() +
                getYDistance() * getYDistance() +
                getZDistance() * getZDistance()
        );
    }

    private int getXDistance() {
        return Math.abs(box1.x() - box2.x());
    }

    private int getYDistance() {
        return Math.abs(box1.y() - box2.y());
    }

    private int getZDistance() {
        return Math.abs(box1.z() - box2.z());
    }
}
