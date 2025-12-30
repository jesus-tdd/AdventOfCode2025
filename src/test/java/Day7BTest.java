import org.junit.Test;
import software.aoc.day07.common.io.CellListParser;
import software.aoc.day07.common.model.Cell;
import software.aoc.day07.common.model.Grid;
import software.aoc.day07.common.factory.GridBuilder;
import software.aoc.day07.common.services.QuantumGridSimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Day7BTest {
    @Test
    public void start_tachyon_beam() {
        Grid grid = TestGridBuilder.from(
                ".S.",
                "..."
        );
        assertThat(new QuantumGridSimulator(grid).step().countTimelines()).isEqualTo(1);
        assertThat(new QuantumGridSimulator(grid).simulate().countTimelines()).isEqualTo(1);
    }

    @Test
    public void split_tachyon_beam() {
        Grid grid = TestGridBuilder.from(
                ".S.",
                "...",
                ".^.",
                "..."
        );
        assertThat(new QuantumGridSimulator(grid).step().countTimelines()).isEqualTo(1);
        assertThat(new QuantumGridSimulator(grid).simulate().countTimelines()).isEqualTo(2);
    }

    private static class TestGridBuilder {
        public static Grid from(String... strings) {
            List<List<Cell>> list = new ArrayList<>();
            Arrays.stream(strings).map(CellListParser::parse).forEach(list::add);

            return new GridBuilder()
                    .rows(list.size())
                    .columns(list.getFirst().size())
                    .cells(list)
                    .build();
        }
    }
}
