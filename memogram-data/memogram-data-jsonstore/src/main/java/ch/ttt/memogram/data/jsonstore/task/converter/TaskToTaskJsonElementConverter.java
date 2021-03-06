package ch.ttt.memogram.data.jsonstore.task.converter;

import ch.ttt.memogram.data.jsonstore.task.TaskJsonElement;
import ch.ttt.memogram.domain.tag.Tag;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskToTaskJsonElementConverter implements Converter<Task, TaskJsonElement> {

    @Override
    public TaskJsonElement convert(final Task element) {
        return new TaskJsonElement(element.getKey().getId(),
                element.getTitle(),
                element.getDeadline(),
                Converter.convertList(element.getTags(), Tag::getName));
    }
}
