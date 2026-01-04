package software.aoc.day08.common.io;

import software.aoc.common.io.InputParser;
import software.aoc.day08.common.model.JunctionBox;

public class JunctionBoxParser implements InputParser<JunctionBox> {
    @Override
    public JunctionBox parse(String s) {
        return this.parse(s.split(","));
    }

    private JunctionBox parse(String[] split) {
        return new JunctionBox(toInt(split[0]), toInt(split[1]), toInt(split[2]));
    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }
}
