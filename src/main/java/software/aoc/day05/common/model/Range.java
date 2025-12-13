package software.aoc.day05.common.model;

public record Range(long from, long to) {
    public boolean contains(long n) {
        return from <= n && n <= to;
    }
}
