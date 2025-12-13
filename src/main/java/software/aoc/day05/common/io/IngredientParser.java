package software.aoc.day05.common.io;

import software.aoc.day05.common.model.Ingredient;

public class IngredientParser {
    public static Ingredient parse(String str) {
        return new Ingredient(toLong(str));
    }

    private static long toLong(String s) {
        return Long.parseLong(s);
    }
}
