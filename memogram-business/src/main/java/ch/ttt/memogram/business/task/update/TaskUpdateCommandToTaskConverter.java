package ch.ttt.memogram.business.task.update;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.shared.converter.Converter;

public class TaskUpdateCommandToTaskConverter implements Converter<TaskUpdateCommand, Task> {

    @Override
    public Task convert(final TaskUpdateCommand element) {
        return Task.from(TaskKey.from(element.getUuid()), element.getTitle(), element.getDeadline());
    }
}
