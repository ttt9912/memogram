package ch.ttt.memogram.business.task;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.business.abstractions.DomainService;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;

public class TaskService extends DomainService<Task, TaskKey> {

    public TaskService(final DomainRepository<Task, TaskKey> repository) {
        super(repository);
    }

    public void createTask(final CreateTaskCommand command) {
        final Task task = Task.from(command.getTitle(), command.getDeadline());
        super.create(task.getKey(), task);
    }

    public void updateTask(final UpdateTaskCommand command) {
        final Task task = new Task(TaskKey.from(command.getUuid()), command.getTitle(), command.getDeadline());
        super.update(task.getKey(), task);
    }
}
