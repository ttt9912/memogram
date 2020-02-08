package ch.ttt.memogram.jsonstore.task.converter;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.jsonstore.abstractions.Converter;
import ch.ttt.memogram.jsonstore.task.TaskJsonElement;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter implements Converter<TaskJsonElement, Task> {
    private final Converter<TaskJsonElement, TaskKey> keyConverter;

    public TaskConverter(final Converter<TaskJsonElement, TaskKey> keyConverter) {
        this.keyConverter = keyConverter;
    }

    @Override
    public Task convert(final TaskJsonElement element) {
        return new Task(keyConverter.convert(element),
                element.getTitle(),
                element.getDeadline());
    }
}
