import org.junit.Test;
import software.aoc.day01.common.model.Dial;
import software.aoc.day01.common.model.Rotation;

import static org.assertj.core.api.Assertions.*;
import static software.aoc.day01.common.model.Rotation.Direction.L;
import static software.aoc.day01.common.model.Rotation.Direction.R;

public class Day1BTest {
    @Test
    public void count_zeros_when_rotating_left() {
        Dial dial = new Dial(0, 99, 50);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(L, 1))).isEqualTo(0);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(L, 49))).isEqualTo(0);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(L, 50))).isEqualTo(1);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(L, 51))).isEqualTo(1);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(L, 100))).isEqualTo(1);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(L, 150))).isEqualTo(2);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(L, 200))).isEqualTo(2);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(L, 1000))).isEqualTo(10);
    }

    @Test
    public void count_zeros_when_rotating_right() {
        Dial dial = new Dial(0, 99, 50);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(R, 1))).isEqualTo(0);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(R, 49))).isEqualTo(0);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(R, 50))).isEqualTo(1);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(R, 51))).isEqualTo(1);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(R, 100))).isEqualTo(1);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(R, 150))).isEqualTo(2);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(R, 200))).isEqualTo(2);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(R, 1000))).isEqualTo(10);
    }

    @Test
    public void count_zeros_when_not_rotating() {
        Dial dial = new Dial(0, 99, 0);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(L, 0))).isEqualTo(0);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(R, 0))).isEqualTo(0);
    }

    @Test
    public void count_zeros_starting_at_zero() {
        Dial dial = new Dial(0, 99, 0);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(L, 1))).isEqualTo(0);
        assertThat(dial.predictPassesThroughStartWith(new Rotation(R, 1))).isEqualTo(0);
    }
}
