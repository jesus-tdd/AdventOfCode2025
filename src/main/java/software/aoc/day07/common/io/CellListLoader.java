package software.aoc.day07.common.io;

import io.github.cdimascio.dotenv.Dotenv;
import software.aoc.common.io.InputLoader;
import software.aoc.day07.common.model.Cell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CellListLoader implements InputLoader<List<Cell>> {
    private final Function<String, List<Cell>> deserialize;

    public CellListLoader(Function<String, List<Cell>> deserialize) {
        this.deserialize = deserialize;
    }

    @Override
    public List<List<Cell>> loadAll() {
        try {
            return loadFrom(new URL("https://adventofcode.com/2025/day/7/input"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<List<Cell>> loadFrom(URL url) throws IOException {
        try (InputStream is = getOpenConnection(url).getInputStream()) {
            return loadFrom(toReader(is));
        }
    }

    private static URLConnection getOpenConnection(URL url) throws IOException {
        String session = Dotenv.load().get("AOC_SESSION");
        URLConnection c = url.openConnection();
        c.setRequestProperty("Cookie", "session="+session);
        return c;
    }

    private List<List<Cell>> loadFrom(BufferedReader reader) throws IOException {
        List<List<Cell>> list = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            list.add(deserialize.apply(line));
        }
        return list;
    }

    private BufferedReader toReader(InputStream is) {
        return new BufferedReader(new InputStreamReader(is));
    }
}
