package ch.ttt.memogram.business.task.delete;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.abstraction.delete.DomainDeleteService;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;

public class TaskDeleteService extends DomainDeleteService<TaskKey, Task> {

    public TaskDeleteService(final DomainRepository<TaskKey, Task> repository) {
        super(repository);
    }
}
