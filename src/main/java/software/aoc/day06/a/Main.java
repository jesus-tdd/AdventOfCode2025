package software.aoc.day06.a;

import software.aoc.day06.common.io.OperationLoader;
import software.aoc.day06.common.io.OperationParser;
import software.aoc.day06.common.model.Operation;

import java.util.List;

public class Main {
    static void main() {
        List<Operation> homework = new OperationLoader(new OperationParser()::parse).loadAll();
        long total = homework.stream().map(Operation::apply).reduce(0L, Long::sum);
        System.out.println("Grand total: " + total);
    }
}
