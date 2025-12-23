package software.aoc.day06.common.io;

import software.aoc.day06.common.model.Operation;
import software.aoc.day06.common.model.Product;
import software.aoc.day06.common.model.Sum;

import java.util.Arrays;
import java.util.List;

public class OperationParser {
    public static Operation parse(String[] column) {
        if (column[column.length - 1].charAt(0) == '+') {
            return new Sum(getNumbers(column));
        }
        else {
            return new Product(getNumbers(column));
        }
    }

    private static List<Long> getNumbers(String[] column) {
        return Arrays.stream(column)
                .limit(column.length - 1)
                .map(s -> s.replaceAll(" ",""))
                .filter(s -> !s.isEmpty())
                .map(Long::parseLong)
                .toList();
    }
}
