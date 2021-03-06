package ch.ttt.memogram.datajpa.task.convert;

import ch.ttt.memogram.datajpa.task.TaskEntity;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.tag.Tag;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskEntityToTaskConverter implements Converter<TaskEntity, Task> {

    @Override
    public Task convert(final TaskEntity element) {
        return new Task(UUIDKey.from(element.getUuid()),
                element.getTitle(),
                element.getDeadline(),
                Converter.convertList(element.getTags(), Tag::new),
                element.getDeleted());
    }
}
