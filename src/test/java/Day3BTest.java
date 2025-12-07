import org.junit.Test;
import software.aoc.day03.common.model.Bank;
import software.aoc.day03.common.model.Battery;

import static org.assertj.core.api.Assertions.*;

public class Day3BTest {
    @Test
    public void two_digit_max_jolts_between_two_batteries() {
        Bank bank = new Bank();
        bank.put(new Battery(1));
        bank.put(new Battery(2));

        assertThat(bank.getMaxJolts(2)).isEqualTo(12);
    }

    @Test
    public void two_digit_max_jolts_in_list() {
        Bank bank = new Bank();
        int[] powers = {8,1,8,1,8,1,9,1,1,1,1,2,1,1,1};
        for (int power : powers) {
            bank.put(new Battery(power));
        }

        assertThat(bank.getMaxJolts(2)).isEqualTo(92);
    }

    @Test
    public void twelve_digit_max_jolts_in_list() {
        Bank bank = new Bank();
        int[] powers = {8,1,8,1,8,1,9,1,1,1,1,2,1,1,1};
        for (int power : powers) {
            bank.put(new Battery(power));
        }

        assertThat(bank.getMaxJolts(12)).isEqualTo(888911112111L);
    }
}
