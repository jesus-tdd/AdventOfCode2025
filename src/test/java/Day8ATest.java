import org.junit.Test;
import software.aoc.day08.common.model.Circuit;
import software.aoc.day08.common.model.JunctionBox;
import software.aoc.day08.common.model.JunctionBoxPair;
import software.aoc.day08.common.stores.CircuitStore;

import static org.assertj.core.api.Assertions.*;

public class Day8ATest {
    @Test
    public void test_distance_equals_to_zero() {
        assertThat(Cases.X0Y0Z0_X0Y0Z0_PAIR().distanceSquared()).isEqualTo(0);
    }

    @Test
    public void test_distance_equals_to_one() {

        assertThat(Cases.X0Y0Z0_X1Y0Z0_PAIR().distanceSquared()).isEqualTo(1);
    }
    @Test
    public void test_distance() {
        assertThat(Cases.X0Y0Z0_X1Y2Z3_PAIR().distanceSquared()).isEqualTo(14);
    }

    @Test
    public void test_put_existing_box_in_circuit() {
        assertThat(Cases.ONE_BOX_CIRCUIT().put(Cases.X0_Y0_Z0()).size()).isEqualTo(1);
    }

    @Test
    public void test_extend_circuit() {
        assertThat(Cases.EMPTY_CIRCUIT().extend(Cases.ONE_BOX_CIRCUIT()).size()).isEqualTo(1);
    }

    @Test
    public void test_extend_circuit_with_existing_elements() {
        assertThat(Cases.ONE_BOX_CIRCUIT().extend(Cases.ONE_BOX_CIRCUIT()).size()).isEqualTo(1);
    }

    @Test
    public void test_empty_store() {
        assertThat(Cases.EMPTY_STORE().size()).isEqualTo(0);
    }

    @Test
    public void test_put_pair_in_empty_store() {
        CircuitStore store = Cases.EMPTY_STORE();
        store.put(Cases.X0Y0Z0_X1Y0Z0_PAIR());

        assertThat(store.size()).isEqualTo(1);
    }

    @Test
    public void test_put_pair_in_new_circuit_in_store() {
        CircuitStore store = Cases.ONE_CIRCUIT_STORE();
        store.put(Cases.X0Y1Z0_X0Y0Z1_PAIR());
        assertThat(store.size()).isEqualTo(2);
    }

    @Test
    public void test_put_pair_in_existing_circuit_in_store() {
        CircuitStore store = Cases.ONE_CIRCUIT_STORE();
        store.put(Cases.X0Y0Z0_X0Y1Z0_PAIR());
        assertThat(store.size()).isEqualTo(1);
    }

    @Test
    public void test_put_existing_pair_in_store() {
        CircuitStore store = Cases.ONE_CIRCUIT_STORE();
        store.put(Cases.X0Y0Z0_X1Y0Z0_PAIR());
        assertThat(store.size()).isEqualTo(1);
    }

    @Test
    public void test_join_two_circuits_in_store() {
        CircuitStore store = Cases.TWO_CIRCUIT_STORE();
        store.put(Cases.X0Y0Z0_X0Y1Z0_PAIR());
        assertThat(store.size()).isEqualTo(1);
    }

    private static class Cases {
        private static JunctionBox X0_Y0_Z0() {
            return new JunctionBox(0, 0, 0);
        }

        private static JunctionBox X1_Y0_Z0() {
            return new JunctionBox(1, 0, 0);
        }

        private static JunctionBox X0_Y1_Z0() {
            return new JunctionBox(0, 1, 0);
        }

        private static JunctionBox X0_Y0_Z1() {
            return new JunctionBox(0, 0, 1);
        }

        private static JunctionBox X1_Y2_Z3() {
            return new JunctionBox(1, 2, 3);
        }


        private static JunctionBoxPair X0Y0Z0_X0Y0Z0_PAIR() {
            return new JunctionBoxPair(X0_Y0_Z0(), X0_Y0_Z0());
        }

        private static JunctionBoxPair X0Y0Z0_X1Y0Z0_PAIR() {
            return new JunctionBoxPair(X0_Y0_Z0(), X1_Y0_Z0());
        }

        private static JunctionBoxPair X0Y0Z0_X0Y1Z0_PAIR() {
            return new JunctionBoxPair(X0_Y0_Z0(), X0_Y1_Z0());
        }

        private static JunctionBoxPair X0Y1Z0_X0Y0Z1_PAIR() {
            return new JunctionBoxPair(X0_Y1_Z0(), X0_Y0_Z1());
        }

        private static JunctionBoxPair X0Y0Z0_X1Y2Z3_PAIR() {
            return new JunctionBoxPair(X0_Y0_Z0(), X1_Y2_Z3());
        }


        private static Circuit EMPTY_CIRCUIT() {
            return Circuit.create();
        }

        private static Circuit ONE_BOX_CIRCUIT() {
            return Circuit.create().put(X0_Y0_Z0());
        }


        private static CircuitStore EMPTY_STORE() {
            return new CircuitStore();
        }

        private static CircuitStore ONE_CIRCUIT_STORE() {
            CircuitStore store = new CircuitStore();
            store.put(X0Y0Z0_X1Y0Z0_PAIR());
            return store;
        }

        public static CircuitStore TWO_CIRCUIT_STORE() {
            CircuitStore store = new CircuitStore();
            store.put(X0Y0Z0_X1Y0Z0_PAIR());
            store.put(X0Y1Z0_X0Y0Z1_PAIR());
            return store;
        }
    }
}
