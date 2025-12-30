package software.aoc.day03.b;

import software.aoc.day03.common.io.BankLoader;
import software.aoc.day03.common.io.BankParser;
import software.aoc.day03.common.model.Bank;

import java.util.List;

public class Main {
    static void main() {
        List<Bank> list = new BankLoader(new BankParser()::parse).loadAll();
        long total = list.stream().map(b -> b.getMaxJolts(12)).reduce(0L, Long::sum);
        System.out.println("Total jolts: " + total);
    }
}
