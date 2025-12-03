import org.junit.Test;
import software.aoc.day01.a.model.Dial;
import software.aoc.day01.a.model.Rotation;

import static org.assertj.core.api.Assertions.*;

import static software.aoc.day01.a.model.Rotation.Direction.L;
import static software.aoc.day01.a.model.Rotation.Direction.R;

public class Day1ATest {
    @Test
    public void rotate_dial_left() {
        Dial dial = new Dial(50);
        assertThat(dial.rotate(new Rotation(L, 1)).pointingAt()).isEqualTo(49);
        assertThat(dial.rotate(new Rotation(L, 50)).pointingAt()).isEqualTo(0);
        assertThat(dial.rotate(new Rotation(L, 51)).pointingAt()).isEqualTo(99);
    }

    @Test
    public void rotate_dial_right() {
        Dial dial = new Dial(50);
        assertThat(dial.rotate(new Rotation(R, 1)).pointingAt()).isEqualTo(51);
        assertThat(dial.rotate(new Rotation(R, 50)).pointingAt()).isEqualTo(0);
        assertThat(dial.rotate(new Rotation(R, 51)).pointingAt()).isEqualTo(1);
    }
}
