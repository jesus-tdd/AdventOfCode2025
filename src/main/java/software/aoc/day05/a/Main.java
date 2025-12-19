package software.aoc.day05.a;

import software.aoc.day05.common.io.IngredientLoader;
import software.aoc.day05.common.io.IngredientParser;
import software.aoc.day05.common.io.RangeLoader;
import software.aoc.day05.common.io.RangeParser;
import software.aoc.day05.common.model.Ingredient;
import software.aoc.day05.common.model.Range;
import software.aoc.day05.common.stores.RangeStore;

import java.util.List;

public class Main {
    static void main() {
        RangeStore store = new RangeStore();
        store.put(getRanges());

        long freshIngredients = getIngredients().stream().filter(i -> store.contains(i.id())).count();
        System.out.println("Number of fresh ingredients: " + freshIngredients);
    }

    private static List<Range> getRanges() {
        return new RangeLoader(RangeParser::parse).loadAll();
    }

    private static List<Ingredient> getIngredients() {
        return new IngredientLoader(IngredientParser::parse).loadAll();
    }
}
