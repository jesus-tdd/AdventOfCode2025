import org.junit.Test;
import software.aoc.day06.common.model.Product;
import software.aoc.day06.common.model.Sum;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Day6ATest {
    @Test
    public void sum_two_numbers() {
        assertThat(new Sum(List.of(2L, 3L)).apply()).isEqualTo(5);
    }

    @Test
    public void sum_three_numbers() {
        assertThat(new Sum(List.of(4L, 6L, 57L )).apply()).isEqualTo(67);
    }

    @Test
    public void sum_three_zeros() {
        assertThat(new Sum(List.of(0L, 0L, 0L )).apply()).isEqualTo(0);
    }

    @Test
    public void multiply_by_one() {
        assertThat(new Product(List.of(2L, 1L)).apply()).isEqualTo(2);
    }

    @Test
    public void multiply_by_zero() {
        assertThat(new Product(List.of(2L, 0L)).apply()).isEqualTo(0);
    }

    @Test
    public void aoc_example() {
        assertThat(new Product(List.of(123L, 45L, 6L)).apply()).isEqualTo(33210);
        assertThat(new Sum(List.of(328L, 64L, 98L)).apply()).isEqualTo(490);
        assertThat(new Product(List.of(51L, 387L, 215L)).apply()).isEqualTo(4243455);
        assertThat(new Sum(List.of(64L, 23L, 314L)).apply()).isEqualTo(401);
    }
}
