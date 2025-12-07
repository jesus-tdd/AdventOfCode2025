package software.aoc.day03.common.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Bank {
    private final List<Battery> list;

    public Bank() {
        list = new ArrayList<>();
    }

    public void put(Battery battery) {
        list.add(battery);
    }


    public void put(List<Battery> batteries) {
        for (Battery b : batteries) {
            this.put(b);
        }
    }

    public int getMaxJolts() {
        Battery firstBattery = list.subList(0, list.size()-1).stream()
                .max(Battery::compare).orElseThrow();
        Battery secondBattery = list.subList(list.indexOf(firstBattery)+1, list.size()).stream()
                .max(Battery::compare).orElseThrow();

        return firstBattery.power()*10 + secondBattery.power();
    }

    public long getMaxJolts(int nDigits) {
        List<Battery> digits = new ArrayList<>();
        int nextIndex = 0;
        for (int i = 0; i < nDigits; i++) {
            List<Battery> sublist = list.subList(nextIndex, getSublistLimit(nDigits, i));
            Battery battery = sublist.stream().max(Battery::compare).orElseThrow();
            nextIndex += sublist.indexOf(battery) + 1;
            digits.add(battery);
        }

        return digits.stream().map(b -> (long) b.power()).reduce(0L, (p1, p2) -> p1 * 10 + p2);
    }

    private int getSublistLimit(int nDigits, int index) {
        return list.size() - nDigits + index + 1;
    }
}
