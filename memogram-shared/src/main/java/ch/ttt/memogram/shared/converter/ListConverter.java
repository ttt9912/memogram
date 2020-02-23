package ch.ttt.memogram.shared.converter;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class ListConverter {

    public static <ELEMENT, RESULT> List<RESULT> convertList(final List<ELEMENT> elements, final Function<ELEMENT, RESULT> mapper) {
        if (elements == null) {
            return null;
        }
        return elements.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
