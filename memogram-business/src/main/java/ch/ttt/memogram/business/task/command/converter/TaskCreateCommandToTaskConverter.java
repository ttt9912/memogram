package ch.ttt.memogram.business.task.command.converter;

import ch.ttt.memogram.business.task.command.TaskCreateCommand;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.shared.converter.Converter;

public class TaskCreateCommandToTaskConverter implements Converter<TaskCreateCommand, Task> {

    @Override
    public Task convert(final TaskCreateCommand element) {
        return Task.from(element.getTitle(), element.getDeadline());
    }
}
