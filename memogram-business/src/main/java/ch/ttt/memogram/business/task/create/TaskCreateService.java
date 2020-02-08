package ch.ttt.memogram.business.task.create;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.abstraction.create.DomainCreateService;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;

public class TaskCreateService extends DomainCreateService<TaskKey, Task, TaskCreateCommand> {

    public TaskCreateService(final DomainRepository<TaskKey, Task> repository,
                             final TaskCreateCommandToTaskConverter converter) {
        super(repository, converter);
    }
}
