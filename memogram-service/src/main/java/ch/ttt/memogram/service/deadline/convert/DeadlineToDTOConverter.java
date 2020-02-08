package ch.ttt.memogram.service.deadline.convert;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.service.abstractions.Converter;
import ch.ttt.memogram.service.deadline.TaskDTO;
import org.springframework.stereotype.Component;

@Component
public class DeadlineToDTOConverter implements Converter<Task, TaskDTO> {

    @Override
    public TaskDTO convert(final Task task) {
        return new TaskDTO(
                task.getTitle(),
                task.getDeadline());
    }
}
