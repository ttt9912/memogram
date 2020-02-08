package ch.ttt.memogram.jsonstore.task.converter;

import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.jsonstore.abstraction.Converter;
import ch.ttt.memogram.jsonstore.task.TaskJsonElement;
import org.springframework.stereotype.Component;

@Component
public class TaskKeyConverter implements Converter<TaskJsonElement, TaskKey> {

    @Override
    public TaskKey convert(final TaskJsonElement element) {
        return TaskKey.from(element.getId());
    }
}
