package software.aoc.day01.a.app;

import software.aoc.day01.a.app.io.RemoteRotationLoader;
import software.aoc.day01.a.model.Dial;
import software.aoc.day01.a.model.Rotation;
import software.aoc.day01.a.model.Rotation.Direction;

import java.util.List;

public class Main {

    static void main() {
        List<Rotation> rotations = new RemoteRotationLoader(Main::toRotation).loadAll();
        Dial dial = new Dial(0, 99, 50);
        int count = 0;
        for (Rotation rotation : rotations) {
            dial = dial.rotate(rotation);
            if(dial.isPointingAt(0)) count++;
        }
        System.out.println("Password: " + count);
    }

    private static Rotation toRotation(String s) {
        return new Rotation(toDirection(s.substring(0, 1)), toInt(s.substring(1)));
    }

    private static Direction toDirection(String s) {
        return Direction.valueOf(s);
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
