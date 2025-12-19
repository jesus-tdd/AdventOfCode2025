import org.junit.Test;
import software.aoc.day05.common.model.Range;
import software.aoc.day05.common.stores.RangeStore;

import static org.assertj.core.api.Assertions.*;

public class Day5BTest {
    @Test
    public void ranges_do_not_intersect() {
        assertThat(new Range(1, 3).intersects(new Range(4, 6))).isFalse();
        assertThat(new Range(2, 3).intersects(new Range(0, 1))).isFalse();
    }

    @Test
    public void ranges_intersect() {
        assertThat(new Range(1, 3).intersects(new Range(3, 6))).isTrue();
        assertThat(new Range(1, 3).intersects(new Range(0, 1))).isTrue();
        assertThat(new Range(1, 10).intersects(new Range(3, 7))).isTrue();
    }

    @Test
    public void put_intersecting_ranges_in_store() {
        RangeStore store = new RangeStore();
        store.put(new Range(1, 10));
        store.put(new Range(2, 11));
        store.put(new Range(0, 3));

        assertThat(store.size()).isEqualTo(1);
    }

    @Test
    public void range_size() {
        assertThat(new Range(1, 5).size()).isEqualTo(5);
    }
}
