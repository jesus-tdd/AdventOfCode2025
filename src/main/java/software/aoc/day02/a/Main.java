package software.aoc.day02.a;

import software.aoc.day02.common.io.RemoteRangeLoader;
import software.aoc.day02.a.model.Range;

import java.util.List;

public class Main {
    static void main() {
        List<Range> ranges = new RemoteRangeLoader(Main::toRange).loadAll();
        long total = 0;
        for (Range range : ranges) {
            total += range.findInvalidIds();
        }
        System.out.println("Sum of invalid IDs: " + total);
    }

    private static Range toRange(String s) {
        String[] split = s.replaceAll("\n", "").split("-");
        return new Range(toLong(split[0]), toLong(split[1]));
    }

    private static long toLong(String s) {
        return Long.parseLong(s);
    }
}
