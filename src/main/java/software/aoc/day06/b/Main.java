package software.aoc.day06.b;

import software.aoc.day06.common.io.CephalopodOperationParser;
import software.aoc.day06.common.io.OperationLoader;
import software.aoc.day06.common.model.Operation;

import java.util.List;

public class Main {
    static void main() {
        List<Operation> homework = new OperationLoader(new CephalopodOperationParser()::parse).loadAll();
        long total = homework.stream().map(Operation::apply).reduce(0L, Long::sum);
        System.out.println("Grand total: " + total);
    }
}
