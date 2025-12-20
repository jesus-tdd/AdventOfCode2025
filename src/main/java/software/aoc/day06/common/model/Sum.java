package software.aoc.day06.common.model;

import java.util.List;

public class Sum implements Operation {
    private final List<Long> numbers;

    public Sum(List<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    public long apply() {
        return numbers.stream().reduce(0L, Long::sum);
    }
}
