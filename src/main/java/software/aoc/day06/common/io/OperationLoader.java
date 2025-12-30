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
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperationLoader implements InputLoader<Operation> {
    private final Function<String, Operation> deserialize;

    public OperationLoader(Function<String, Operation> deserialize) {
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
        List<String> lines = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            lines.add(line);
        }

        return getColumns(lines).stream().map(deserialize).toList();
    }

    private static List<String> getColumns(List<String> lines) {
        Map<Integer, Integer> columnRanges = getColumnRanges(lines.getLast());
        ArrayList<String> list = new ArrayList<>();
        for (int pos : columnRanges.keySet()) {
            list.add(lines.stream()
                    .map(s -> s.substring(pos, columnRanges.get(pos)))
                            .collect(Collectors.joining("\n"))
            );
        }
        return list;
    }

    private static Map<Integer, Integer> getColumnRanges(String operators) {
        List<Integer> operatorPositions = IntStream.range(0, operators.length())
                .filter( i -> operators.charAt(i) == '+' || operators.charAt(i) == '*')
                .boxed()
                .toList();

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < operatorPositions.size(); i++) {
            map.put(
                    operatorPositions.get(i),
                    (i + 1 < operatorPositions.size())? operatorPositions.get(i+1)-1 : operators.length()
            );
        }
        return map;
    }

    private BufferedReader toReader(InputStream is) {
        return new BufferedReader(new InputStreamReader(is));
    }
}
