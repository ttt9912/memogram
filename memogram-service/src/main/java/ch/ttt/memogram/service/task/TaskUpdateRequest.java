package ch.ttt.memogram.service.task;

import ch.ttt.memogram.business.task.update.TaskUpdateCommand;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.service.abstraction.DomainRequest;
import lombok.Value;

@Value
public class TaskUpdateRequest implements DomainRequest<TaskKey, TaskUpdateCommand> {
    private TaskKey key;
    private TaskUpdateCommand command;
}
