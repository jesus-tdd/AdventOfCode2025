package software.aoc.day02.common.stores;

import software.aoc.day02.common.model.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class RangeStore {
    private final List<Range> ranges;
    
    public RangeStore() {
        ranges = new ArrayList<>();
    }
    
    public void put(List<Range> ranges) {
        for (Range r : ranges) {
            this.put(r);
        }
    }

    public void put(Range range) {
        this.ranges.add(range);
    }

    public Stream<Range> stream() {
        return this.ranges.stream();
    }

    public Stream<Long> expandedStream() {
        return this.stream().flatMap(r -> LongStream.rangeClosed(r.from(), r.to()).boxed());
    }
}
