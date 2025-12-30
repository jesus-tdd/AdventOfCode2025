package software.aoc.day02.b;

import software.aoc.day02.common.io.RangeLoader;
import software.aoc.day02.common.io.RangeParser;
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
        return (n + "").matches("^(\\d+)\\1+$");
    }

    private static List<Range> getRanges() {
        return new RangeLoader(new RangeParser()::parse).loadAll();
    }
}