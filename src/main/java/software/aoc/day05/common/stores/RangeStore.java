package software.aoc.day05.common.stores;

import software.aoc.day05.common.model.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RangeStore {
    private final List<Range> ranges;

    public RangeStore() {
        ranges = new ArrayList<>();
    }

    public void put(Range range) {
        List<Range> list = new ArrayList<>(this.getIntersectingRanges(range).toList());
        this.remove(list);
        list.add(range);
        ranges.add(new Range(
                list.stream().map(Range::from).min(Long::compare).orElseThrow(),
                list.stream().map(Range::to).max(Long::compare).orElseThrow()
        ));
    }

    public void put(List<Range> ranges) {
        ranges.forEach(this::put);
    }

    public void remove(Range range) {
        ranges.remove(range);
    }

    public void remove(List<Range> ranges) {
        ranges.forEach(this::remove);
    }

    public boolean contains(long n) {
        return this.ranges.stream().anyMatch(r -> r.contains(n));
    }

    public Stream<Range> getIntersectingRanges(Range range) {
        return ranges.stream().filter(r -> r.intersects(range));
    }

    public long size() {
        return ranges.size();
    }

    public long expandedSize() {
        return ranges.stream().map(Range::size).reduce(0L, Long::sum);
    }
}
