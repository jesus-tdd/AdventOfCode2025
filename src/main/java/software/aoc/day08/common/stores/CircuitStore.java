package software.aoc.day08.common.stores;

import software.aoc.day08.common.model.Circuit;
import software.aoc.day08.common.model.JunctionBox;
import software.aoc.day08.common.model.JunctionBoxPair;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CircuitStore {
    private final List<Circuit> circuits;

    public CircuitStore() {
        circuits = new ArrayList<>();
    }

    public void put(JunctionBoxPair pair) {
        if(contains(pair)) joinCircuitsWith(pair.box1(), pair.box2());
        else if (contains(pair.box1())) getCircuitWith(pair.box1()).put(pair.box2());
        else if (contains(pair.box2())) getCircuitWith(pair.box2()).put(pair.box1());
        else circuits.add(Circuit.create().put(pair));
    }

    private void joinCircuitsWith(JunctionBox box1, JunctionBox box2) {
        if (getCircuitWith(box1) == getCircuitWith(box2)) return;
        getCircuitWith(box1).extend(getCircuitWith(box2));
        circuits.remove(getCircuitWith(box2));
    }

    private Circuit getCircuitWith(JunctionBox box) {
        for (Circuit circuit : circuits) {
            if (circuit.contains(box)) return circuit;
        }
        throw new NoSuchElementException();
    }

    private boolean contains(JunctionBoxPair pair) {
        return contains(pair.box1()) && contains(pair.box2());
    }

    private boolean contains(JunctionBox box) {
        for (Circuit circuit : circuits) {
            if (circuit.contains(box)) return true;
        }
        return false;
    }

    public List<Circuit> getNLargest(int n) {
        return circuits.stream()
                .sorted((c1, c2) -> Double.compare(c2.size(), c1.size()))
                .limit(n)
                .toList();
    }

    public int size() {
        return circuits.size();
    }
}
