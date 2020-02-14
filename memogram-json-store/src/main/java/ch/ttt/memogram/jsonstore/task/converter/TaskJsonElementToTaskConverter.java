package ch.ttt.memogram.jsonstore.task.converter;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.jsonstore.task.TaskJsonElement;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskJsonElementToTaskConverter implements Converter<TaskJsonElement, Task> {
    private final TaskJsonElementToUUIDKeyConverter keyConverter;

    public TaskJsonElementToTaskConverter(final TaskJsonElementToUUIDKeyConverter keyConverter) {
        this.keyConverter = keyConverter;
    }

    @Override
    public Task convert(final TaskJsonElement element) {
        return new Task(keyConverter.convert(element),
                element.getTitle(),
                element.getDeadline());
    }
}
