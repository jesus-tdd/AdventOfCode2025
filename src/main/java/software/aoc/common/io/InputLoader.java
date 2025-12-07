package software.aoc.common.io;

import java.util.List;

public interface InputLoader<T> {
    List<T> loadAll();
}
