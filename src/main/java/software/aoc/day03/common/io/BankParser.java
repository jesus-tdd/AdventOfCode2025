package software.aoc.day03.common.io;

import software.aoc.common.io.InputParser;
import software.aoc.day03.common.model.Bank;
import software.aoc.day03.common.model.Battery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankParser implements InputParser<Bank> {
    @Override
    public Bank parse(String s) {
        Bank bank = new Bank();
        bank.put(toBatteries(s));
        return bank;
    }

    private List<Battery> toBatteries(String s) {
        ArrayList<Battery> list = new ArrayList<>();
        Arrays.stream(s.split("")).forEach(c -> list.add(new Battery(toInt(c))));
        return list;
    }

    private int toInt(String s) {
        return Integer.parseInt(s);
    }
}
