package software.aoc.day02.common.io;

import software.aoc.day02.common.model.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RangeParser {
    public static Stream<Range> parse(String string) {
        List<Range> list = new ArrayList<>();
        for (String s : string.split(",")) {
            list.add(toRange(s));
        }
        return list.stream();
    }

    private static Range toRange(String s) {
        String[] split = s.replaceAll("\n", "").split("-");
        return new Range(toLong(split[0]), toLong(split[1]));
    }

    private static long toLong(String s) {
        return Long.parseLong(s);
    }
}
