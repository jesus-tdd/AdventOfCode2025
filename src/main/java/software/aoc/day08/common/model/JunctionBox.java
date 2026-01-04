package software.aoc.day08.common.model;

public class JunctionBox {
    private final Coordinate coordinates;

    public JunctionBox(int x, int y, int z) {
        this.coordinates = new Coordinate(x, y, z);
    }

    public int x() {
        return coordinates.x;
    }

    public int y() {
        return coordinates.y;
    }

    public int z() {
        return coordinates.z;
    }

    private record Coordinate(int x, int y, int z) { }
}
