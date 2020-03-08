package ch.ttt.memogram.data.jsonstore.task;

import ch.ttt.memogram.data.jsonstore.abstraction.DomainRepositoryImpl;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository extends DomainRepositoryImpl<UUIDKey, Task, TaskJsonElement> {

    public TaskRepository(final TaskStore taskStore) {
        super(taskStore);
    }
}
