package software.aoc.day08.a;

import software.aoc.day08.common.model.Circuit;
import software.aoc.day08.common.model.JunctionBoxPair;
import software.aoc.day08.common.stores.JunctionBoxStore;
import software.aoc.day08.common.stores.CircuitStore;

import java.util.List;

public class Main {

    static void main() {
        JunctionBoxStore boxes = new JunctionBoxStore();
        List<JunctionBoxPair> pairs = boxes.getNClosestPairs(1000);

        CircuitStore circuits = new CircuitStore();
        for (JunctionBoxPair pair : pairs) {
            circuits.put(pair);
        }

        long productOfSizes = circuits.getNLargest(3).stream()
                .map(Circuit::size)
                .reduce(1, (s1, s2) -> s1 * s2);

        System.out.println("Product: " + productOfSizes);
    }
}
