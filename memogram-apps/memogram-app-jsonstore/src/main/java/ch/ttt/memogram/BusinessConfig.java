package ch.ttt.memogram;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.business.task.TaskService;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.domain.task.TaskKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {

    @Bean
    public TaskService taskService(final DomainRepository<Task, TaskKey> taskRepository) {
        return new TaskService(taskRepository);
    }
}
