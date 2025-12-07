package software.aoc.day03.common.io;

import software.aoc.day03.common.model.Bank;
import software.aoc.day03.common.model.Battery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BankParser {
    public static Stream<Bank> parse(String s) {
        Bank bank = new Bank();
        bank.put(toBatteries(s));
        return Stream.of(bank);
    }

    private static List<Battery> toBatteries(String s) {
        ArrayList<Battery> list = new ArrayList<>();
        Arrays.stream(s.split("")).forEach(c -> list.add(new Battery(toInt(c))));
        return list;
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
