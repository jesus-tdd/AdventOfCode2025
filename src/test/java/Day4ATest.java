import org.junit.Test;
import software.aoc.day04.common.model.Cell;
import software.aoc.day04.common.model.Grid;

import static org.assertj.core.api.Assertions.*;
import static software.aoc.day04.common.model.Cell.Status.Empty;
import static software.aoc.day04.common.model.Cell.Status.Roll;

public class Day4ATest {
    @Test
    public void count_no_rolls_1x1_empty() {
        Grid grid = new Grid(1, 1);
        grid.set(0,0, new Cell(Empty));

        assertThat(grid.countRollsAdjacentTo(0, 0)).isEqualTo(0);
    }

    @Test
    public void count_no_rolls_1x1_roll() {
        Grid grid = new Grid(1, 1);
        grid.set(0,0, new Cell(Roll));

        assertThat(grid.countRollsAdjacentTo(0, 0)).isEqualTo(0);
    }

    @Test
    public void count_rolls_2x2() {
        Grid grid = new Grid(2, 2);
        grid.set(0,0, new Cell(Roll));
        grid.set(1,0, new Cell(Empty));
        grid.set(0,1, new Cell(Empty));
        grid.set(1,1, new Cell(Roll));

        assertThat(grid.countRollsAdjacentTo(0, 0)).isEqualTo(1);
        assertThat(grid.countRollsAdjacentTo(1, 0)).isEqualTo(2);
        assertThat(grid.countRollsAdjacentTo(0, 1)).isEqualTo(2);
        assertThat(grid.countRollsAdjacentTo(1, 1)).isEqualTo(1);
    }

    @Test
    public void count_rolls_3x3() {
        Grid grid = new Grid(3, 3);
        grid.set(0,0, new Cell(Roll));
        grid.set(1,0, new Cell(Empty));
        grid.set(2,0, new Cell(Roll));

        grid.set(0,1, new Cell(Empty));
        grid.set(1,1, new Cell(Roll));
        grid.set(2,1, new Cell(Empty));

        grid.set(0,2, new Cell(Roll));
        grid.set(1,2, new Cell(Empty));
        grid.set(2,2, new Cell(Roll));

        assertThat(grid.countRollsAdjacentTo(1,1)).isEqualTo(4);
    }

    @Test
    public void count_only_rolls_3x3() {
        Grid grid = new Grid(3, 3);
        grid.set(0,0, new Cell(Roll));
        grid.set(1,0, new Cell(Roll));
        grid.set(2,0, new Cell(Roll));

        grid.set(0,1, new Cell(Roll));
        grid.set(1,1, new Cell(Roll));
        grid.set(2,1, new Cell(Roll));

        grid.set(0,2, new Cell(Roll));
        grid.set(1,2, new Cell(Roll));
        grid.set(2,2, new Cell(Roll));

        assertThat(grid.countRollsAdjacentTo(1,1)).isEqualTo(8);
    }

    @Test
    public void count_no_rolls_3x3() {
        Grid grid = new Grid(3, 3);
        grid.set(0,0, new Cell(Empty));
        grid.set(1,0, new Cell(Empty));
        grid.set(2,0, new Cell(Empty));

        grid.set(0,1, new Cell(Empty));
        grid.set(1,1, new Cell(Roll));
        grid.set(2,1, new Cell(Empty));

        grid.set(0,2, new Cell(Empty));
        grid.set(1,2, new Cell(Empty));
        grid.set(2,2, new Cell(Empty));

        assertThat(grid.countRollsAdjacentTo(1,1)).isEqualTo(0);
    }
}
