package ch.ttt.memogram.jsonstore.common;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<SOURCE, TARGET> {

    TARGET convert(SOURCE element);

    default List<TARGET> convertAll(final List<SOURCE> collection) {
        return collection.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
