package ch.ttt.memogram.business.task.command;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.abstraction.command.DomainCommandService;
import ch.ttt.memogram.business.task.command.converter.TaskCreateCommandToTaskConverter;
import ch.ttt.memogram.business.task.command.converter.TaskUpdateCommandToTaskConverter;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;

public class TaskCommandService extends DomainCommandService<UUIDKey, Task, TaskCreateCommand, TaskUpdateCommand> {

    public TaskCommandService(final DomainRepository<UUIDKey, Task> repository,
                              final TaskCreateCommandToTaskConverter createEntityConverter,
                              final TaskUpdateCommandToTaskConverter updateEntityConverter) {
        super(repository, createEntityConverter, updateEntityConverter);
    }
}
