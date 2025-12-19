package software.aoc.day05.common.model;

public record Range(long from, long to) {
    public boolean contains(long n) {
        return from <= n && n <= to;
    }

    public boolean intersects(Range other) {
        return !(other.to < this.from || other.from > this.to);
    }

    public long size() {
        return to - from + 1;
    }
}
