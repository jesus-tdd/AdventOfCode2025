import org.junit.Test;
import software.aoc.day05.common.model.Range;
import software.aoc.day05.common.stores.RangeStore;

import static org.assertj.core.api.Assertions.*;

public class Day5ATest {
    @Test
    public void range_contains_first() {
        Range range = new Range(0, 3);
        assertThat(range.contains(0)).isTrue();
    }

    @Test
    public void range_contains_last() {
        Range range = new Range(0, 3);
        assertThat(range.contains(3)).isTrue();
    }

    @Test
    public void range_contains() {
        Range range = new Range(0, 3);
        assertThat(range.contains(2)).isTrue();
    }

    @Test
    public void range_not_contains() {
        Range range = new Range(0, 3);
        assertThat(range.contains(6)).isFalse();
    }

    @Test
    public void range_store_contains() {
        RangeStore store = new RangeStore();
        store.put(new Range(0, 3));
        store.put(new Range(7, 10));
        assertThat(store.contains(0)).isTrue();
        assertThat(store.contains(3)).isTrue();
        assertThat(store.contains(7)).isTrue();
        assertThat(store.contains(10)).isTrue();
    }

    @Test
    public void range_store_not_contains() {
        RangeStore store = new RangeStore();
        store.put(new Range(0, 3));
        store.put(new Range(7, 10));
        assertThat(store.contains(4)).isFalse();
        assertThat(store.contains(11)).isFalse();
    }
}
