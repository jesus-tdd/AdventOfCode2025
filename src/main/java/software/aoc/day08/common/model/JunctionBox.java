package software.aoc.day08.common.model;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof JunctionBox that)) return false;
        return Objects.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return coordinates.hashCode();
    }

    private record Coordinate(int x, int y, int z) {
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Coordinate that)) return false;
            return x == that.x && y == that.y && z == that.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }
}
