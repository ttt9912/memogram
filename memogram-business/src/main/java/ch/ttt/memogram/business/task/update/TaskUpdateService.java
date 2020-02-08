package ch.ttt.memogram.business.task.update;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.abstraction.update.DomainUpdateService;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;

public class TaskUpdateService extends DomainUpdateService<TaskKey, Task, TaskUpdateCommand> {

    public TaskUpdateService(final DomainRepository<TaskKey, Task> repository,
                             final TaskUpdateCommandToTaskConverter converter,
                             final TaskUpdateCommandToTaskKeyConverter keyConverter) {
        super(repository, converter, keyConverter);
    }
}
