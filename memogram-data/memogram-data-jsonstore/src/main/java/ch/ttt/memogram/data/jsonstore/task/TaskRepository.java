package ch.ttt.memogram.data.jsonstore.task;

import ch.ttt.memogram.data.jsonstore.abstraction.with_jsonelement.DomainRepositoryWJsonImpl;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository extends DomainRepositoryWJsonImpl<UUIDKey, Task, TaskJsonElement> {

    public TaskRepository(final TaskStore taskStore) {
        super(taskStore);
    }
}
