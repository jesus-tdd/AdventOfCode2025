package software.aoc.day05.common.io;

import io.github.cdimascio.dotenv.Dotenv;
import software.aoc.common.io.InputLoader;
import software.aoc.day05.common.model.Range;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RangeLoader implements InputLoader<Range> {
    private final Function<String, Range> deserialize;

    public RangeLoader(Function<String, Range> deserialize) {
        this.deserialize = deserialize;
    }

    @Override
    public List<Range> loadAll() {
        try {
            return loadFrom(new URL("https://adventofcode.com/2025/day/5/input"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Range> loadFrom(URL url) throws IOException {
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

    private List<Range> loadFrom(BufferedReader reader) throws IOException {
        List<Range> list = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            if (! line.contains("-")) continue;
            list.add(deserialize.apply(line));
        }
        return list;
    }

    private BufferedReader toReader(InputStream is) {
        return new BufferedReader(new InputStreamReader(is));
    }
}
