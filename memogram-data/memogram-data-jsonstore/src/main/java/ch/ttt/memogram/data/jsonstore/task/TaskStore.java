package ch.ttt.memogram.data.jsonstore.task;

import ch.ttt.memogram.data.jsonstore.abstraction.JsonFileStore;
import ch.ttt.memogram.data.jsonstore.task.converter.TaskJsonElementToTaskConverter;
import ch.ttt.memogram.data.jsonstore.task.converter.TaskJsonElementToUUIDKeyConverter;
import ch.ttt.memogram.data.jsonstore.task.converter.TaskToTaskJsonElementConverter;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskStore extends JsonFileStore<UUIDKey, Task, TaskJsonElement> {

    public TaskStore(final TaskToTaskJsonElementConverter jsonConverter,
                     final TaskJsonElementToTaskConverter entityConverter,
                     final TaskJsonElementToUUIDKeyConverter keyConverter) {
        super(jsonConverter, entityConverter, keyConverter);
    }

    @Override
    protected Class<TaskJsonElement> getJsonElementClass() {
        return TaskJsonElement.class;
    }
}
