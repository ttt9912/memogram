package ch.ttt.memogram;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.task.create.TaskCreateService;
import ch.ttt.memogram.business.task.delete.TaskDeleteService;
import ch.ttt.memogram.business.task.query.TaskQueryService;
import ch.ttt.memogram.business.task.update.TaskUpdateService;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {

    @Bean
    public TaskQueryService taskQueryService(final DomainRepository<TaskKey, Task> taskRepository) {
        return new TaskQueryService(taskRepository);
    }

    @Bean
    public TaskUpdateService taskUpdateService(final DomainRepository<TaskKey, Task> taskRepository) {
        return new TaskUpdateService(taskRepository);
    }

    @Bean
    public TaskCreateService taskCreateService(final DomainRepository<TaskKey, Task> taskRepository) {
        return new TaskCreateService(taskRepository);
    }

    @Bean
    public TaskDeleteService taskDeleteService(final DomainRepository<TaskKey, Task> taskRepository) {
        return new TaskDeleteService(taskRepository);
    }
}
