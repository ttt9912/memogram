package ch.ttt.memogram.jsonstore.task;

import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.jsonstore.abstractions.DomainRepositoryImpl;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository extends DomainRepositoryImpl<Task, TaskKey, TaskJsonElement> {

    public TaskRepository(final TaskStore taskStore) {
        super(taskStore);
    }
}
