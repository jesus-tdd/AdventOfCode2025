package software.aoc.day02.a;

import software.aoc.day02.common.io.RemoteRangeLoader;
import software.aoc.day02.common.model.Range;
import software.aoc.day02.common.stores.RangeStore;

import java.util.List;

public class Main {
    static void main() {
        RangeStore store = new RangeStore();
        store.put(getRanges());
        Long total = store.expandedStream()
                          .filter(Main::isInvalid)
                          .reduce(0L, Long::sum);

        System.out.println("Sum of invalid IDs: " + total);
    }

    private static boolean isInvalid(Long n) {
        return (n + "").matches("^(\\d+)\\1$");
    }

    private static List<Range> getRanges() {
        return new RemoteRangeLoader(Main::toRange).loadAll();
    }

    private static Range toRange(String s) {
        String[] split = s.replaceAll("\n", "").split("-");
        return new Range(toLong(split[0]), toLong(split[1]));
    }

    private static long toLong(String s) {
        return Long.parseLong(s);
    }
}
