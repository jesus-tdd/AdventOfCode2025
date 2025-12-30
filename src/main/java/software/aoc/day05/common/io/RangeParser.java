package software.aoc.day05.common.io;

import software.aoc.common.io.InputParser;
import software.aoc.day05.common.model.Range;

public class RangeParser implements InputParser<Range> {
    @Override
    public Range parse(String str) {
        return parse(str.split("-"));
    }

    private Range parse(String[] split) {
        return new Range(toLong(split[0]), toLong(split[1]));
    }

    private long toLong(String s) {
        return Long.parseLong(s);
    }
}
