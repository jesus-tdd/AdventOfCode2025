package software.aoc.day08.common.stores;

import software.aoc.day08.common.model.Circuit;
import software.aoc.day08.common.model.JunctionBox;
import software.aoc.day08.common.model.JunctionBoxPair;

import java.util.ArrayList;
import java.util.List;

public class CircuitStore {
    private final List<Circuit> circuits;

    private CircuitStore() {
        circuits = new ArrayList<>();
    }

    public CircuitStore put(List<JunctionBoxPair> pairs) {
        pairs.forEach(this::put);
        return this;
    }

    public CircuitStore put(JunctionBoxPair pair) {
        if(contains(pair)) joinCircuitsWith(pair.box1(), pair.box2());
        else if (contains(pair.box1())) getCircuitWith(pair.box1()).put(pair.box2());
        else if (contains(pair.box2())) getCircuitWith(pair.box2()).put(pair.box1());
        else circuits.add(Circuit.create().put(pair));
        return this;
    }

    private void joinCircuitsWith(JunctionBox box1, JunctionBox box2) {
        if (getCircuitWith(box1) == getCircuitWith(box2)) return;
        getCircuitWith(box1).extend(getCircuitWith(box2));
        circuits.removeIf(c -> c.contains(box2) && !c.contains(box1));
    }

    private Circuit getCircuitWith(JunctionBox box) {
        return circuits.stream()
                .filter(c -> c.contains(box))
                .findAny()
                .orElseThrow();
    }

    private boolean contains(JunctionBoxPair pair) {
        return contains(pair.box1()) && contains(pair.box2());
    }

    private boolean contains(JunctionBox box) {
        return circuits.stream().anyMatch(c -> c.contains(box));
    }

    public List<Circuit> getNLargest(int n) {
        return circuits.stream()
                .sorted((c1, c2) -> Integer.compare(c2.size(), c1.size()))
                .limit(n)
                .toList();
    }

    public int size() {
        return circuits.size();
    }

    public static CircuitStore create() {
        return new CircuitStore();
    }
}
