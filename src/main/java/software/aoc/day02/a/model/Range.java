package software.aoc.day02.a.model;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public record Range(long from, long to) {

    public Stream<Long> getRangeStream() {
        return LongStream.rangeClosed(from, to).boxed();
    }
}
