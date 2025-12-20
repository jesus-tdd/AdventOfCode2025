package software.aoc.day06.common.model;

import java.util.List;

public class Product implements Operation{
    private final List<Long> numbers;

    public Product(List<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    public long apply() {
        return numbers.stream().reduce(1L, Math::multiplyExact);
    }
}
