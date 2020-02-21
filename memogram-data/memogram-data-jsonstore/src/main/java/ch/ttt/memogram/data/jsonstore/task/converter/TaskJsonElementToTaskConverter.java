package ch.ttt.memogram.data.jsonstore.task.converter;

import ch.ttt.memogram.data.jsonstore.task.TaskJsonElement;
import ch.ttt.memogram.domain.tag.Tag;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

import static ch.ttt.memogram.shared.converter.ListConverter.convertList;

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
                element.getDeadline(),
                convertList(element.getTags(), Tag::new));
    }
}
