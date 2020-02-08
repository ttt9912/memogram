package ch.ttt.memogram.business.task.update;

import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.shared.converter.Converter;

public class TaskUpdateCommandToTaskKeyConverter implements Converter<TaskUpdateCommand, TaskKey> {

    @Override
    public TaskKey convert(final TaskUpdateCommand element) {
        return TaskKey.from(element.getUuid());
    }
}
