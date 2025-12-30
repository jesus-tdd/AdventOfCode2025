package software.aoc.day06.common.io;

import software.aoc.common.io.InputParser;
import software.aoc.day06.common.model.Operation;
import software.aoc.day06.common.model.Product;
import software.aoc.day06.common.model.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class CephalopodOperationParser implements InputParser<Operation> {
    @Override
    public Operation parse(String s) {
        return parse(s.split("\n"));
    }

    public Operation parse(String[] column) {
        if (column[column.length - 1].charAt(0) == '+') {
            return new Sum(getNumbers(column));
        }
        else {
            return new Product(getNumbers(column));
        }
    }

    private List<Long> getNumbers(String[] column) {
        List<Long> list = new ArrayList<>();
        for (int i = column[0].length()-1; i >= 0; i--) {
            list.add(getNumberAt(column, i));
        }
        return list;
    }

    private Long getNumberAt(String[] column, int i) {
        return getNumberAt(Arrays.stream(column)
                .filter(s -> s.matches("\\s*[0-9]+\\s*"))
                .map(s -> s.charAt(i))
                .map(String::valueOf)
                .collect(joining())
        );
    }

    private Long getNumberAt(String number) {
        return Long.parseLong(number.replaceAll(" ", ""));
    }

}
