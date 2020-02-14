package ch.ttt.memogram.service.task;

import ch.ttt.memogram.business.task.command.TaskCommandService;
import ch.ttt.memogram.business.task.command.TaskCreateCommand;
import ch.ttt.memogram.business.task.command.TaskUpdateCommand;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.service.abstraction.DomainCommandController;
import ch.ttt.memogram.service.task.convert.StringToTaskKeyConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tasks")
public class TaskCommandController extends DomainCommandController<UUIDKey, Task, TaskCreateCommand, TaskUpdateCommand> {

    public TaskCommandController(final TaskCommandService commandService,
                                 final StringToTaskKeyConverter keyConverter) {
        super(commandService, keyConverter);
    }
}
