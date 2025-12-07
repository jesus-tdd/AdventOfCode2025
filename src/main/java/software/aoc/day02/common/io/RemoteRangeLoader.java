package software.aoc.day02.common.io;

import io.github.cdimascio.dotenv.Dotenv;
import software.aoc.day02.a.model.Range;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RemoteRangeLoader implements RangeLoader{
    private final Function<String, Range> deserialize;

    public RemoteRangeLoader(Function<String, Range> deserialize) {
        this.deserialize = deserialize;
    }

    @Override
    public List<Range> loadAll() {
        try {
            return loadFrom(new URL("https://adventofcode.com/2025/day/2/input"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Range> loadFrom(URL url) throws IOException {
        try (InputStream is = getUrlConnection(url).getInputStream()) {
            return loadFrom(new InputStreamReader(is));
        }
    }

    private List<Range> loadFrom(InputStreamReader reader) throws IOException {
        ArrayList<Range> ranges = new ArrayList<>();
        String line = reader.readAllAsString();
        for (String s : line.split(",")) {
            ranges.add(deserialize.apply(s));
        }
        return ranges;
    }

    private static URLConnection getUrlConnection(URL url) throws IOException {
        URLConnection c = url.openConnection();
        c.setRequestProperty("Cookie", "session=" + Dotenv.load().get("AOC_SESSION"));
        return c;
    }
}
