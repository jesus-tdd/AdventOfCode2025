package software.aoc.day01.common.io;

import io.github.cdimascio.dotenv.Dotenv;
import software.aoc.day01.common.model.Rotation;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RemoteRotationLoader implements RotationLoader {
    private final Function<String, Rotation> deserialize;

    public RemoteRotationLoader(Function<String, Rotation> deserialize) {
        this.deserialize = deserialize;
    }

    @Override
    public List<Rotation> loadAll() {
        try {
            return loadFrom(new URL("https://adventofcode.com/2025/day/1/input"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Rotation> loadFrom(URL url) throws IOException {
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

    private List<Rotation> loadFrom(BufferedReader reader) throws IOException {
        List<Rotation> list = new ArrayList<>();
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
