package ch.ttt.memogram.service.task;

import ch.ttt.memogram.business.task.create.TaskCreateCommand;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.service.abstraction.DomainRequest;
import lombok.Value;

@Value
public class TaskCreateRequest implements DomainRequest<TaskKey, TaskCreateCommand> {
    private TaskKey key;
    private TaskCreateCommand command;
}
