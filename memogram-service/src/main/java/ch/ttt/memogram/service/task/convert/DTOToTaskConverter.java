package ch.ttt.memogram.service.task.convert;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.service.abstractions.Converter;
import ch.ttt.memogram.service.task.TaskDTO;
import org.springframework.stereotype.Component;

@Component
public class DTOToTaskConverter implements Converter<TaskDTO, Task> {

    @Override
    public Task convert(final TaskDTO element) {
        return new Task(TaskKey.from(element.getId()),
                element.getTitle(),
                element.getDeadline());
    }
}
