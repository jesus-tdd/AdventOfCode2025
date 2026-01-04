package software.aoc.day08.common.model;

import java.util.HashSet;
import java.util.Set;

public class Circuit {
    private final Set<JunctionBox> boxes;

    public Circuit() {
        boxes = new HashSet<>();
    }

    public boolean contains(JunctionBox box) {
        return boxes.contains(box);
    }

    public Circuit put(JunctionBoxPair pair) {
        boxes.add(pair.box1());
        boxes.add(pair.box2());
        return this;
    }

    public double size() {
        return boxes.size();
    }

    public static Circuit create() {
        return new Circuit();
    }
}
