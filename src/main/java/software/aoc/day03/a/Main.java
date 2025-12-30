package software.aoc.day03.a;

import software.aoc.day03.common.io.BankLoader;
import software.aoc.day03.common.io.BankParser;
import software.aoc.day03.common.model.Bank;

import java.util.List;

public class Main {
    static void main() {
        List<Bank> list = new BankLoader(new BankParser()::parse).loadAll();
        int total = list.stream().map(Bank::getMaxJolts).reduce(0, Integer::sum);
        System.out.println("Total jolts: " + total);
    }
}