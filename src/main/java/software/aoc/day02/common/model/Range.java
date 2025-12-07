package software.aoc.day02.common.model;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public record Range(long from, long to) {

    public Stream<Long> getRangeStream() {
        return LongStream.rangeClosed(from, to).boxed();
    }

    public long findInvalidIds() {
        return this.getRangeStream()
                .filter(id -> (id + "").matches("^(\\d+)\\1$"))
                .reduce(0L, Long::sum);
    }
}
