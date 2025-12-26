package software.aoc.day06.common.model;

import java.util.List;

public class Product implements Operation {
    private final List<Long> numbers;

    public Product(List<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    public long apply() {
        return numbers.stream().reduce(1L, Math::multiplyExact);
    }

    @Override
    public boolean equals(Operation other) {
        if (! (other instanceof Product)) return false;

        Product product = (Product) other;
        if (this.numbers.size() != product.numbers.size()) return false;
        for (int i = 0; i < this.numbers.size(); i++) {
            if (!this.numbers.get(i).equals(product.numbers.get(i))) return false;
        }
        return true;
    }
}
