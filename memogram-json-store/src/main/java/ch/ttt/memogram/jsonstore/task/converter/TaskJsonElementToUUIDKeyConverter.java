package ch.ttt.memogram.jsonstore.task.converter;

import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.jsonstore.task.TaskJsonElement;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskJsonElementToUUIDKeyConverter implements Converter<TaskJsonElement, UUIDKey> {

    @Override
    public UUIDKey convert(final TaskJsonElement element) {
        return UUIDKey.from(element.getId());
    }
}
