package software.aoc.day03.b;

import software.aoc.common.io.RemoteInputLoader;
import software.aoc.day03.common.io.BankParser;
import software.aoc.day03.common.model.Bank;

import java.util.List;

public class Main {
    static void main() {
        List<Bank> list = new RemoteInputLoader<>(3, BankParser::parse).loadAll();
        long total = list.stream().map(b -> b.getMaxJolts(12)).reduce(0L, Long::sum);
        System.out.println("Total jolts: " + total);
    }
}
