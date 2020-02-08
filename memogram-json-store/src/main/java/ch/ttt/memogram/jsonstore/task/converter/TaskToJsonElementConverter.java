package ch.ttt.memogram.jsonstore.task.converter;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.jsonstore.abstractions.Converter;
import ch.ttt.memogram.jsonstore.task.TaskJsonElement;
import org.springframework.stereotype.Component;

@Component
public class TaskToJsonElementConverter implements Converter<Task, TaskJsonElement> {

    @Override
    public TaskJsonElement convert(final Task element) {
        return new TaskJsonElement(element.getKey().getId(),
                element.getTitle(),
                element.getDeadline());
    }
}