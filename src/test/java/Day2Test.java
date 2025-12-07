import org.junit.Test;
import software.aoc.day02.common.model.Range;
import software.aoc.day02.common.stores.RangeStore;

import static org.assertj.core.api.Assertions.*;

public class Day2Test {
    @Test
    public void no_elements_store() {
        RangeStore store = new RangeStore();
        assertThat(store.stream().count()).isEqualTo(0);
        assertThat(store.expandedStream().count()).isEqualTo(0);
    }

    @Test
    public void one_element_store() {
        RangeStore store = new RangeStore();
        store.put(new Range(0, 5));
        assertThat(store.stream().count()).isEqualTo(1);
        assertThat(store.expandedStream().count()).isEqualTo(6);
    }

    @Test
    public void more_elements_store() {
        RangeStore store = new RangeStore();
        store.put(new Range(0, 5));
        store.put(new Range(6, 10));
        assertThat(store.stream().count()).isEqualTo(2);
        assertThat(store.expandedStream().count()).isEqualTo(11);
    }

    @Test
    public void disperse_ranges_store() {
        RangeStore store = new RangeStore();
        store.put(new Range(0, 5));
        store.put(new Range(15,17));
        store.put(new Range(30,39));
        assertThat(store.stream().count()).isEqualTo(3);
        assertThat(store.expandedStream().count()).isEqualTo(19);
    }

}
