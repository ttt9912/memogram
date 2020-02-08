package ch.ttt.memogram.business.task;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.business.abstractions.DomainService;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;

import java.util.Optional;

public class TaskService extends DomainService<Task, TaskKey> {
    private final DomainRepository<Task, TaskKey> repository;

    public TaskService(final DomainRepository<Task, TaskKey> repository) {
        super(repository);
        this.repository = repository;
    }

    public void create(final CreateTaskCommand command) {
        repository.save(Task.from(command.getTitle(), command.getDeadline()));
    }

    public void update(final UpdateTaskCommand command) {
        final Optional<Task> existing = repository.findByKey(TaskKey.from(command.getUuid()));
        // TODO
    }
}
