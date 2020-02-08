package ch.ttt.memogram.business.task.query;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.abstraction.query.DomainQueryService;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;

public class TaskQueryService extends DomainQueryService<TaskKey, Task> {

    public TaskQueryService(final DomainRepository<TaskKey, Task> repository) {
        super(repository);
    }

}
