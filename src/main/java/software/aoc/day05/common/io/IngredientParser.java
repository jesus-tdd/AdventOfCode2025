package software.aoc.day05.common.io;

import software.aoc.common.io.InputParser;
import software.aoc.day05.common.model.Ingredient;

public class IngredientParser implements InputParser<Ingredient> {
    @Override
    public Ingredient parse(String str) {
        return new Ingredient(toLong(str));
    }

    private long toLong(String s) {
        return Long.parseLong(s);
    }
}
