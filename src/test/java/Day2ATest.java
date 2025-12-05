import org.junit.Test;
import software.aoc.day02.a.model.Range;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Day2ATest {
    @Test
    public void return_range_stream() {
        Range range = new Range(0, 5);
        assertThat(range.getRangeStream().count()).isEqualTo(6);
        assertThat(range.getRangeStream().toList()).isEqualTo(List.of(0L, 1L, 2L, 3L, 4L, 5L));
    }

    @Test
    public void find_no_invalid_ids() {
        Range range = new Range(0, 9);
        assertThat(range.findInvalidIds()).isEqualTo(0);
    }

    @Test
    public void find_one_invalid_id() {
        Range range = new Range(21, 32);
        assertThat(range.findInvalidIds()).isEqualTo(22);
    }

    @Test
    public void find_two_invalid_ids() {
        Range range = new Range(21, 34);
        assertThat(range.findInvalidIds()).isEqualTo(55);
    }

    @Test
    public void find_many_invalid_ids() {
        Range range = new Range(1000, 1500);
        assertThat(range.findInvalidIds()).isEqualTo(1010+1111+1212+1313+1414);
    }
}
