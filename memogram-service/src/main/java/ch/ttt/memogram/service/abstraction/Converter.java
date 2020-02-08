package ch.ttt.memogram.service.abstraction;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface Converter<SOURCE, TARGET> {

    TARGET convert(SOURCE element);

    default List<TARGET> convertAll(final Collection<SOURCE> collection) {
        return collection.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
