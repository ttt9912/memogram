package ch.ttt.memogram.jsonstore.task;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.jsonstore.abstractions.JsonFileStore;
import org.springframework.stereotype.Component;

@Component
public class TaskStore extends JsonFileStore<Task, TaskKey, TaskJsonElement> {

    @Override
    protected Class<TaskJsonElement> getJsonElementClass() {
        return TaskJsonElement.class;
    }
}
