package ch.ttt.memogram.jsonstore.task.converter;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.jsonstore.task.TaskJsonElement;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskJsonElementToTaskConverter implements Converter<TaskJsonElement, Task> {
    private final Converter<TaskJsonElement, TaskKey> keyConverter;

    public TaskJsonElementToTaskConverter(final Converter<TaskJsonElement, TaskKey> keyConverter) {
        this.keyConverter = keyConverter;
    }

    @Override
    public Task convert(final TaskJsonElement element) {
        return Task.from(keyConverter.convert(element),
                element.getTitle(),
                element.getDeadline());
    }
}
