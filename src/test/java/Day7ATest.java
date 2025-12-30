import org.junit.Test;
import software.aoc.day07.common.io.CellListParser;
import software.aoc.day07.common.model.Cell;
import software.aoc.day07.common.model.Grid;
import software.aoc.day07.common.factory.GridBuilder;
import software.aoc.day07.common.services.GridSimulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static software.aoc.day07.common.model.Cell.State.Empty;
import static software.aoc.day07.common.model.Cell.State.TachyonBeam;

public class Day7ATest {
    @Test
    public void start_tachyon_beam() {
        Grid grid = TestGridBuilder.from(
                ".S.",
                "..."
        );
        assertThat(new GridSimulator(grid).step().grid().get(1, 1).state()).isEqualTo(TachyonBeam);
    }
    @Test
    public void continue_tachyon_beam() {
        Grid grid = TestGridBuilder.from(
                ".|.",
                "..."
        );
        assertThat(new GridSimulator(grid).step().grid().get(1, 1).state()).isEqualTo(TachyonBeam);
    }

    @Test
    public void split_nothing() {
        Grid grid = TestGridBuilder.from(
                "...",
                ".^.",
                "..."
        );
        assertThat(new GridSimulator(grid).step().grid().get(1, 0).state()).isEqualTo(Empty);
        assertThat(new GridSimulator(grid).step().grid().get(1, 2).state()).isEqualTo(Empty);
        assertThat(new GridSimulator(grid).step().grid().getActiveSplitters()).isEqualTo(0);
    }

    @Test
    public void split_tachyon_beam() {
        Grid grid = TestGridBuilder.from(
                ".|.",
                ".^.",
                "..."
        );
        assertThat(new GridSimulator(grid).step().grid().get(1, 0).state()).isEqualTo(TachyonBeam);
        assertThat(new GridSimulator(grid).step().grid().get(2, 0).state()).isEqualTo(TachyonBeam);
        assertThat(new GridSimulator(grid).step().grid().get(1, 2).state()).isEqualTo(TachyonBeam);
        assertThat(new GridSimulator(grid).step().grid().get(2, 2).state()).isEqualTo(TachyonBeam);
        assertThat(new GridSimulator(grid).step().grid().getActiveSplitters()).isEqualTo(1);
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