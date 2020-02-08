package ch.ttt.memogram.service.task.convert;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.service.abstractions.Converter;
import ch.ttt.memogram.service.task.TaskDTO;
import org.springframework.stereotype.Component;

@Component
public class TaskToDTOConverter implements Converter<Task, TaskDTO> {

    @Override
    public TaskDTO convert(final Task task) {
        return new TaskDTO(
                task.getKey().getId(),
                task.getTitle(),
                task.getDeadline());
    }
}
