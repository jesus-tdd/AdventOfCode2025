package software.aoc.day05.b;

import software.aoc.day05.common.io.RangeLoader;
import software.aoc.day05.common.io.RangeParser;
import software.aoc.day05.common.model.Range;
import software.aoc.day05.common.stores.RangeStore;

import java.util.List;

public class Main {
    static void main() {
        RangeStore store = new RangeStore();
        store.put(getRanges());

        long freshIds = store.totalNumbers();
        System.out.println("Number of fresh ingredient ids: " + freshIds);
    }

    private static List<Range> getRanges() {
        return new RangeLoader(RangeParser::parse).loadAll();
    }
}
