package ch.ttt.memogram.service.task.convert;

import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToTaskKeyConverter implements Converter<String, TaskKey> {

    @Override
    public TaskKey convert(final String id) {
        return TaskKey.from(id);
    }
}
