import org.junit.Test;
import software.aoc.day04.common.model.Cell;
import software.aoc.day04.common.model.Grid;

import static org.assertj.core.api.Assertions.*;

import static software.aoc.day04.common.model.Cell.Status.Empty;
import static software.aoc.day04.common.model.Cell.Status.Roll;


public class Day4BTest {
    @Test
    public void remove_roll_1x1() {
        Grid grid = new Grid(1, 1);
        grid.set(0, 0, new Cell(Roll));

        grid.removeRollFrom(0, 0);
        assertThat(grid.get(0, 0).status()).isEqualTo(Empty);
    }
}
