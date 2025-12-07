package software.aoc.common.io;

import io.github.cdimascio.dotenv.Dotenv;
import software.aoc.day01.common.model.Rotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class RemoteInputLoader<T> implements InputLoader<T> {
    private final int day;
    private final Function<String, Stream<T>> deserialize;

    public RemoteInputLoader(int day, Function<String, Stream<T>> deserialize) {
        this.day = day;
        this.deserialize = deserialize;
    }

    @Override
    public List<T> loadAll() {
        try {
            return loadFrom(new URL("https://adventofcode.com/2025/day/" + day + "/input"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<T> loadFrom(URL url) throws IOException {
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

    private List<T> loadFrom(BufferedReader reader) throws IOException {
        List<T> list = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            deserialize.apply(line).forEach(list::add);
        }
        return list;
    }

    private BufferedReader toReader(InputStream is) {
        return new BufferedReader(new InputStreamReader(is));
    }
}
