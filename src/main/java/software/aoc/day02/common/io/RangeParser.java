package software.aoc.day02.common.io;

import software.aoc.common.io.InputParser;
import software.aoc.day02.common.model.Range;

public class RangeParser implements InputParser<Range> {
    @Override
    public Range parse(String string) {
        return parse(string.split("-"));
    }

    private Range parse(String[] split) {
        return new Range(toLong(split[0]), toLong(split[1]));
    }

    private long toLong(String s) {
        return Long.parseLong(s);
    }
}
