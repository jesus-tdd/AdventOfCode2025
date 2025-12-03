package software.aoc.day01.a.app.io;

import software.aoc.day01.a.io.DirectionLoader;
import software.aoc.day01.a.model.Rotation.Direction;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RemoteDirectionLoader implements DirectionLoader {
    private final Function<String, Direction> deserialize;

    public RemoteDirectionLoader(Function<String, Direction> deserialize) {
        this.deserialize = deserialize;
    }

    @Override
    public List<Direction> loadAll() {
        try {
            return loadFrom(new URL("https://adventofcode.com/2025/day/1/input"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Direction> loadFrom(URL url) throws IOException {
        try (InputStream is = toInputStream(url.openConnection())) {
            return loadFrom(toReader(is));
        }
    }

    private List<Direction> loadFrom(BufferedReader reader) throws IOException {
        ArrayList<Direction> list = new ArrayList<>();
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
