package ch.ttt.memogram.jsonstore.task;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.jsonstore.abstraction.DomainRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository extends DomainRepositoryImpl<TaskKey, Task, TaskJsonElement> {

    public TaskRepository(final TaskStore taskStore) {
        super(taskStore);
    }
}
