package software.aoc.day05.common.stores;

import software.aoc.day05.common.model.Range;

import java.util.ArrayList;
import java.util.List;

public class RangeStore {
    private final List<Range> ranges;

    public RangeStore() {
        ranges = new ArrayList<>();
    }

    public void put(Range range) {
        ranges.add(range);
    }

    public void put(List<Range> ranges) {
        ranges.forEach(this::put);
    }

    public boolean contains(long n) {
        for (Range range : ranges) {
            if (range.contains(n)) return true;
        }
        return false;
    }
}
