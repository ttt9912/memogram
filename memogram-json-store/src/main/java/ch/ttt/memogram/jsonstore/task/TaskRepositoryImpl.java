package ch.ttt.memogram.jsonstore.task;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements DomainRepository<Task, TaskKey> {
    private final TaskStore taskStore;

    public TaskRepositoryImpl(final TaskStore taskStore) {
        this.taskStore = taskStore;
    }

    @Override
    public Collection<Task> findAll() {
        return taskStore.values();
    }

    @Override
    public void save(final Task task) {
        taskStore.save(task.getKey(), task);
    }

    @Override
    public Optional<Task> findByKey(final TaskKey key) {
        return taskStore.value(key);
    }
}
