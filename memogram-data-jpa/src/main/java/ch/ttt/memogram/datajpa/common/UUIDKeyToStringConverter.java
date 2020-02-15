package ch.ttt.memogram.datajpa.common;

import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UUIDKeyToStringConverter implements Converter<UUIDKey, String> {

    @Override
    public String convert(final UUIDKey element) {
        return element.getId();
    }
}
