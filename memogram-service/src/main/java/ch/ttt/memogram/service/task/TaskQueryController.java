package ch.ttt.memogram.service.task;

import ch.ttt.memogram.business.task.query.TaskQueryService;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.service.abstraction.DomainQueryController;
import ch.ttt.memogram.service.task.convert.TaskToTaskDTOConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tasks")
public class TaskQueryController extends DomainQueryController<UUIDKey, Task, TaskDTO> {

    public TaskQueryController(final TaskQueryService queryService,
                               final TaskToTaskDTOConverter dtoConverter) {
        super(queryService, dtoConverter);
    }
}
