package ch.ttt.memogram.service.task.convert;

import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToTaskKeyConverter implements Converter<String, UUIDKey> {

    @Override
    public UUIDKey convert(final String id) {
        return UUIDKey.from(id);
    }
}
