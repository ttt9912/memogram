package ch.ttt.memogram.business.task.update;

import ch.ttt.memogram.business.abstraction.Converter;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;

final class TaskConverter implements Converter<TaskUpdateCommand, Task> {

    @Override
    public Task convert(final TaskUpdateCommand element) {
        return Task.from(TaskKey.from(element.getUuid()), element.getTitle(), element.getDeadline());
    }
}
