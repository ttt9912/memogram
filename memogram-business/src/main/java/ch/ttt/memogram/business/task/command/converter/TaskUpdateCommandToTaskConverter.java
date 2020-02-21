package ch.ttt.memogram.business.task.command.converter;

import ch.ttt.memogram.business.task.command.TaskUpdateCommand;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.shared.converter.Converter;

public class TaskUpdateCommandToTaskConverter implements Converter<TaskUpdateCommand, Task> {

    @Override
    public Task convert(final TaskUpdateCommand element) {
        return new Task(UUIDKey.from(element.getUuid()),
                element.getTitle(),
                element.getDeadline(),
                element.getTags());
    }
}
