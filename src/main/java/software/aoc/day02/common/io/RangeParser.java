package software.aoc.day02.common.io;

import software.aoc.day02.common.model.Range;

public class RangeParser {
    public static Range parse(String s) {
        String[] split = s.replaceAll("\n", "").split("-");
        return new Range(toLong(split[0]), toLong(split[1]));
    }

    private static long toLong(String s) {
        return Long.parseLong(s);
    }
}
