package software.aoc.day01.common.io;

import software.aoc.common.io.InputParser;
import software.aoc.day01.common.model.Rotation;

public class RotationParser  implements InputParser<Rotation> {
    @Override
    public Rotation parse (String s) {
        return new Rotation(toDirection(s.substring(0, 1)), toInt(s.substring(1)));
    }

    private Rotation.Direction toDirection(String s) {
        return Rotation.Direction.valueOf(s);
    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }
}
