import org.junit.Test;
import software.aoc.day06.common.io.CephalopodOperationParser;
import software.aoc.day06.common.model.Operation;
import software.aoc.day06.common.model.Product;
import software.aoc.day06.common.model.Sum;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Day6BTest {
    @Test
    public void cephalopod_parser_two_element_sum_test() {
        Operation parsedString = CephalopodOperationParser.parse(new String[] {"01", "01", "+"});
        assertThat(parsedString.equals(new Sum(List.of(11L, 0L)))).isTrue();
    }

    @Test
    public void cephalopod_parser_three_element_sum_test() {
        Operation parsedString = CephalopodOperationParser.parse(new String[] {"123", "123", "+"});
        assertThat(parsedString.equals(new Sum(List.of(33L, 22L, 11L)))).isTrue();
    }

    @Test
    public void cephalopod_parser_three_element_triple_sum_test() {
        Operation parsedString = CephalopodOperationParser.parse(new String[] {"123", "456", "789", "+"});
        assertThat(parsedString.equals(new Sum(List.of(369L, 258L, 147L)))).isTrue();
    }

    @Test
    public void cephalopod_parser_two_element_product_test() {
        Operation parsedString = CephalopodOperationParser.parse(new String[] {"01", "01", "*"});
        assertThat(parsedString.equals(new Product(List.of(11L, 0L)))).isTrue();
    }

    @Test
    public void cephalopod_parser_three_element_product_test() {
        Operation parsedString = CephalopodOperationParser.parse(new String[] {"123", "123", "*"});
        assertThat(parsedString.equals(new Product(List.of(33L, 22L, 11L)))).isTrue();
    }

    @Test
    public void cephalopod_parser_three_element_triple_product_test() {
        Operation parsedString = CephalopodOperationParser.parse(new String[] {"123", "456", "789", "*"});
        assertThat(parsedString.equals(new Product(List.of(369L, 258L, 147L)))).isTrue();
    }
}
