package software.aoc.day02.common.io;

import software.aoc.day02.a.model.Range;

import java.net.MalformedURLException;
import java.util.List;

public interface RangeLoader {
    List<Range> loadAll() throws MalformedURLException;
}
