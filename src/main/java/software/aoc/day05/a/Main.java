package software.aoc.day05.a;

import software.aoc.common.io.RemoteInputLoader;
import software.aoc.day05.common.io.IngredientParser;
import software.aoc.day05.common.io.RangeParser;
import software.aoc.day05.common.model.Ingredient;
import software.aoc.day05.common.model.Range;
import software.aoc.day05.common.stores.RangeStore;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    static void main() {
        RangeStore store = new RangeStore();
        store.put(getRanges());

        long freshIngredients = getIngredients().stream().filter(i -> store.contains(i.id())).count();
        System.out.println("Number of fresh ingredients: " + freshIngredients);
    }

    private static List<Range> getRanges() {
        return getInput().stream()
                .filter(s -> s.split("-").length == 2)
                .map(RangeParser::parse)
                .toList();
    }

    private static List<Ingredient> getIngredients() {
        return getInput().stream()
                .filter(s -> s.split("-").length < 2)
                .filter(s -> !s.isEmpty())
                .map(IngredientParser::parse)
                .toList();

    }

    private static List<String> getInput() {
        return new RemoteInputLoader<>(5, Stream::of).loadAll();
    }
}
