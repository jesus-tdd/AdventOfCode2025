package software.aoc.day03.common.model;

public record Battery(int power) {
    public static int compare(Battery b1, Battery b2) {
        return b1.power() - b2.power();
    }
}
