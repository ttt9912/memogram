package ch.ttt.memogram.service.task;

import ch.ttt.memogram.business.task.CreateTaskCommand;
import ch.ttt.memogram.business.task.TaskService;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import ch.ttt.memogram.service.abstractions.Converter;
import ch.ttt.memogram.service.abstractions.DomainController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deadlines")
public class TaskController extends DomainController<Task, TaskKey, TaskDTO> {
    private final TaskService service;

    public TaskController(final TaskService service,
                          final Converter<TaskDTO, Task> entityConverter,
                          final Converter<Task, TaskDTO> dtoConverter) {
        super(service, entityConverter, dtoConverter);
        this.service = service;
    }

    @PostMapping // TODO: used?
    public void create(@RequestBody final CreateTaskCommand command) {
        service.create(command);
    }
}
