package software.aoc.day01.common.io;

import software.aoc.day01.common.model.Rotation;

import java.util.stream.Stream;

public class RotationParser {
    public static Stream<Rotation> parse (String s) {
        return Stream.of(toRotation(s));
    }
    private static Rotation toRotation(String s) {
        return new Rotation(toDirection(s.substring(0, 1)), toInt(s.substring(1)));
    }

    private static Rotation.Direction toDirection(String s) {
        return Rotation.Direction.valueOf(s);
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
