package ch.ttt.memogram.shared.converter;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Converter<SOURCE, TARGET> {

    TARGET convert(SOURCE element);

    default List<TARGET> convertAll(final Collection<SOURCE> collection) {
        return collection.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    static <ELEMENT, RESULT> List<RESULT> convertList(final List<ELEMENT> elements, final Function<ELEMENT, RESULT> mapper) {
        if (elements == null) {
            return null;
        }
        return elements.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
