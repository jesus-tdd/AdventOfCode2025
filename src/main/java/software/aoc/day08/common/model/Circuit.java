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

    public Circuit put(JunctionBox box) {
        boxes.add(box);
        return this;
    }

    public Circuit extend(Circuit other) {
        for (JunctionBox box : other.boxes) {
            this.put(box);
        }
        return this;
    }

    public int size() {
        return boxes.size();
    }

    public static Circuit create() {
        return new Circuit();
    }
}
