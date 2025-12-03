package software.aoc.day01.a.app.io;

import software.aoc.day01.a.io.RotationLoader;
import software.aoc.day01.a.model.Rotation;

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
        try (InputStream is = toInputStream(url.openConnection())) {
            return loadFrom(toReader(is));
        }
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

    private InputStream toInputStream(URLConnection connection) throws IOException {
        return new BufferedInputStream(connection.getInputStream());
    }
}
