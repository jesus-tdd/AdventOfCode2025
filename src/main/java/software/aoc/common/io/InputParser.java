package software.aoc.common.io;

public interface InputParser<T> {
    T parse(String s);
}
