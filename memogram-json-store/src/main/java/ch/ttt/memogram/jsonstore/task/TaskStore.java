package ch.ttt.memogram.jsonstore.task;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.jsonstore.abstractions.JsonFileStore;
import ch.ttt.memogram.jsonstore.task.converter.TaskConverter;
import ch.ttt.memogram.jsonstore.task.converter.TaskJsonElementConverter;
import ch.ttt.memogram.jsonstore.task.converter.TaskKeyConverter;
import org.springframework.stereotype.Component;

@Component
public class TaskStore extends JsonFileStore<Task, TaskKey, TaskJsonElement> {

    public TaskStore(final TaskJsonElementConverter jsonConverter,
                     final TaskConverter entityConverter,
                     final TaskKeyConverter keyConverter) {
        super(jsonConverter, entityConverter, keyConverter);
    }

    @Override
    protected Class<TaskJsonElement> getJsonElementClass() {
        return TaskJsonElement.class;
    }
}
