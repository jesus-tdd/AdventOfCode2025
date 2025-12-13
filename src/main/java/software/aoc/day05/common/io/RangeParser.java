package software.aoc.day05.common.io;

import software.aoc.day05.common.model.Range;

public class RangeParser {
    public static Range parse(String str) {
        return parse(str.split("-"));
    }

    private static Range parse(String[] split) {
        return new Range(toLong(split[0]), toLong(split[1]));
    }

    private static long toLong(String s) {
        return Long.parseLong(s);
    }
}
