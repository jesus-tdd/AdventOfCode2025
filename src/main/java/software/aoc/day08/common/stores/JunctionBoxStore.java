package software.aoc.day08.common.stores;

import software.aoc.day08.common.io.JunctionBoxLoader;
import software.aoc.day08.common.io.JunctionBoxParser;
import software.aoc.day08.common.model.JunctionBox;
import software.aoc.day08.common.model.JunctionBoxPair;

import java.util.List;
import java.util.stream.Stream;

public class JunctionBoxStore {
    private final List<JunctionBox> boxes;

    public JunctionBoxStore() {
        boxes = new JunctionBoxLoader(new JunctionBoxParser()::parse).loadAll();
    }

    public List<JunctionBoxPair> getNClosestPairs(int n) {
        return getAllPairs()
                .sorted((b1, b2) -> Long.compare(b1.distanceSquared(), b2.distanceSquared()))
                .limit(n)
                .toList();
    }

    private Stream<JunctionBoxPair> getAllPairs() {
        return boxes.stream().flatMap(this::getPairsOf);
    }

    private Stream<JunctionBoxPair> getPairsOf(JunctionBox box) {
        return boxes.stream()
                .skip(boxes.indexOf(box) + 1)
                .map(b -> new JunctionBoxPair(box, b));
    }
}

