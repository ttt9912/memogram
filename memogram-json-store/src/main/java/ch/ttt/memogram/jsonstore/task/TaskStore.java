package ch.ttt.memogram.jsonstore.task;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.jsonstore.abstraction.JsonFileStore;
import ch.ttt.memogram.jsonstore.task.converter.TaskJsonElementToTaskConverter;
import ch.ttt.memogram.jsonstore.task.converter.TaskJsonElementToTaskKeyConverter;
import ch.ttt.memogram.jsonstore.task.converter.TaskToTaskJsonElementConverter;
import org.springframework.stereotype.Component;

@Component
public class TaskStore extends JsonFileStore<TaskKey, Task, TaskJsonElement> {

    public TaskStore(final TaskToTaskJsonElementConverter jsonConverter,
                     final TaskJsonElementToTaskConverter entityConverter,
                     final TaskJsonElementToTaskKeyConverter keyConverter) {
        super(jsonConverter, entityConverter, keyConverter);
    }

    @Override
    protected Class<TaskJsonElement> getJsonElementClass() {
        return TaskJsonElement.class;
    }
}
