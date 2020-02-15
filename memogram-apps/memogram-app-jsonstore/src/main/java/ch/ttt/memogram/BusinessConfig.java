package ch.ttt.memogram;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.blocker.command.converter.BlockerCreateCommandToBlockerConverter;
import ch.ttt.memogram.business.blocker.command.converter.BlockerUpdateCommandToBlockerConverter;
import ch.ttt.memogram.business.task.command.TaskCommandService;
import ch.ttt.memogram.business.task.command.converter.TaskCreateCommandToTaskConverter;
import ch.ttt.memogram.business.task.command.converter.TaskUpdateCommandToTaskConverter;
import ch.ttt.memogram.business.task.query.TaskQueryService;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {

    private static BlockerCreateCommandToBlockerConverter blockerCommandToBlockerConverter() {
        return new BlockerCreateCommandToBlockerConverter();
    }

    private static BlockerUpdateCommandToBlockerConverter blockerUpdateCommandToBlockerConverter() {
        return new BlockerUpdateCommandToBlockerConverter();
    }

    private static TaskUpdateCommandToTaskConverter taskUpdateCommandToTaskConverter() {
        return new TaskUpdateCommandToTaskConverter();
    }

    private static TaskCreateCommandToTaskConverter taskCreateCommandToTaskConverter() {
        return new TaskCreateCommandToTaskConverter();
    }

    @Bean
    public TaskQueryService taskQueryService(final DomainRepository<UUIDKey, Task> taskRepository) {
        return new TaskQueryService(taskRepository);
    }

    @Bean
    public TaskCommandService taskCommandService(final DomainRepository<UUIDKey, Task> taskRepository) {
        return new TaskCommandService(taskRepository, taskCreateCommandToTaskConverter(), taskUpdateCommandToTaskConverter());
    }
}
