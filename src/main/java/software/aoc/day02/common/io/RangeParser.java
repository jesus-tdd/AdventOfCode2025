package software.aoc.day02.common.io;

import software.aoc.day02.common.model.Range;

public class RangeParser {
    public static Range parse(String string) {
        return parse(string.split("-"));
    }

    private static Range parse(String[] split) {
        return new Range(toLong(split[0]), toLong(split[1]));
    }

    private static long toLong(String s) {
        return Long.parseLong(s);
    }
}
