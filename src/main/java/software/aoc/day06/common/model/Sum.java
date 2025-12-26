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

    @Override
    public boolean equals(Operation operation) {
        if (! (operation instanceof Sum)) return false;
        Sum sum = (Sum) operation;
        if (this.numbers.size() != sum.numbers.size()) return false;
        for (int i = 0; i < this.numbers.size(); i++) {
            if (!this.numbers.get(i).equals(sum.numbers.get(i))) return false;
        }
        return true;
    }
}
