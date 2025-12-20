package software.aoc.day06.common.io;

import io.github.cdimascio.dotenv.Dotenv;
import software.aoc.common.io.InputLoader;
import software.aoc.day06.common.model.Operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class OperationLoader implements InputLoader<Operation> {
    private final Function<String[], Operation> deserialize;

    public OperationLoader(Function<String[], Operation> deserialize) {
        this.deserialize = deserialize;
    }

    @Override
    public List<Operation> loadAll() {
        try {
            return loadFrom(new URL("https://adventofcode.com/2025/day/6/input"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Operation> loadFrom(URL url) throws IOException {
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

    private List<Operation> loadFrom(BufferedReader reader) throws IOException {
        List<String[]> lines = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            lines.add(line.split("\\s+"));
        }
        List<Operation> list = new ArrayList<>();
        for (int i = 0; i < lines.getFirst().length; i++) {
            list.add(deserialize.apply(getColumn(lines, i)));
        }
        return list;
    }

    private static String[] getColumn(List<String[]> lines, int i) {
        return lines.stream().map(l -> l[i]).toArray(String[]::new);
    }

    private BufferedReader toReader(InputStream is) {
        return new BufferedReader(new InputStreamReader(is));
    }
}
