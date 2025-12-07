import org.junit.Test;
import software.aoc.day03.common.model.Bank;
import software.aoc.day03.common.model.Battery;

import static org.assertj.core.api.Assertions.*;

public class Day3ATest {
    @Test
    public void max_jolts_between_two_batteries() {
        Bank bank = new Bank();
        bank.put(new Battery(1));
        bank.put(new Battery(2));

        assertThat(bank.getMaxJolts()).isEqualTo(12);
    }

    @Test
    public void max_jolts_in_list() {
        Bank bank = new Bank();
        int[] powers = {8,1,8,1,8,1,9,1,1,1,1,2,1,1,1};
        for (int power : powers) {
            bank.put(new Battery(power));
        }

        assertThat(bank.getMaxJolts()).isEqualTo(92);
    }
}
