package software.aoc.day05.b;

import software.aoc.common.io.RemoteInputLoader;
import software.aoc.day05.common.io.RangeParser;
import software.aoc.day05.common.model.Range;
import software.aoc.day05.common.stores.RangeStore;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    static void main() {
        RangeStore store = new RangeStore();
        store.put(getRanges());

        long freshIds = store.totalNumbers();
        System.out.println("Number of fresh ingredient ids: " + freshIds);
    }

    private static List<Range> getRanges() {
        return getInput().stream()
                .filter(s -> s.split("-").length == 2)
                .map(RangeParser::parse)
                .toList();
    }

    private static List<String> getInput() {
        return new RemoteInputLoader<>(5, Stream::of).loadAll();
    }
}
