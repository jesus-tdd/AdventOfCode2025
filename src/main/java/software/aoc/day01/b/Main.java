package software.aoc.day01.b;

import software.aoc.day01.common.io.RemoteRotationLoader;
import software.aoc.day01.common.io.RotationParser;
import software.aoc.day01.common.model.Dial;
import software.aoc.day01.common.model.Rotation;

import java.util.List;

public class Main {

    static void main() {
        List<Rotation> rotations = new RemoteRotationLoader(RotationParser::parse).loadAll();
        Dial dial = new Dial(0, 99, 50);
        int count = 0;
        for (Rotation rotation : rotations) {
            count += dial.predictPassesThroughStartWith(rotation);
            dial = dial.rotate(rotation);
        }
        System.out.println("Password: " + count);
    }
}
