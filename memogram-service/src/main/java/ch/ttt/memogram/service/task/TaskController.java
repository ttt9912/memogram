package ch.ttt.memogram.service.task;

import ch.ttt.memogram.business.task.create.TaskCreateCommand;
import ch.ttt.memogram.business.task.create.TaskCreateService;
import ch.ttt.memogram.business.task.delete.TaskDeleteService;
import ch.ttt.memogram.business.task.query.TaskQueryService;
import ch.ttt.memogram.business.task.update.TaskUpdateCommand;
import ch.ttt.memogram.business.task.update.TaskUpdateService;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.service.abstraction.DomainController;
import ch.ttt.memogram.service.task.convert.StringToTaskKeyConverter;
import ch.ttt.memogram.service.task.convert.TaskToTaskDTOConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deadlines")
public class TaskController extends DomainController<TaskKey, Task, TaskCreateCommand, TaskUpdateCommand, TaskDTO> {

    public TaskController(final TaskQueryService queryService,
                          final TaskCreateService createService,
                          final TaskUpdateService updateService,
                          final TaskDeleteService deleteService,
                          final TaskToTaskDTOConverter dtoConverter,
                          final StringToTaskKeyConverter keyConverter) {
        super(queryService, createService, updateService, deleteService, dtoConverter, keyConverter);
    }
}
