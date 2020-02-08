package ch.ttt.memogram.business.task.create;

import ch.ttt.memogram.business.abstraction.Converter;
import ch.ttt.memogram.domain.task.Task;

final class TaskConverter implements Converter<TaskCreateCommand, Task> {

    @Override
    public Task convert(final TaskCreateCommand element) {
        return Task.from(element.getTitle(), element.getDeadline());
    }
}
