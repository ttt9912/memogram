package ch.ttt.memogram;

import ch.ttt.memogram.business.task.command.TaskCommandService;
import ch.ttt.memogram.business.task.command.converter.TaskCreateCommandToTaskConverter;
import ch.ttt.memogram.business.task.command.converter.TaskUpdateCommandToTaskConverter;
import ch.ttt.memogram.business.task.query.TaskQueryService;
import ch.ttt.memogram.business.topic.TopicService;
import ch.ttt.memogram.datajpa.task.TaskRepositoryImpl;
import ch.ttt.memogram.datajpa.topic.TopicRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {

    private static TaskUpdateCommandToTaskConverter taskUpdateCommandToTaskConverter() {
        return new TaskUpdateCommandToTaskConverter();
    }

    private static TaskCreateCommandToTaskConverter taskCreateCommandToTaskConverter() {
        return new TaskCreateCommandToTaskConverter();
    }

    @Bean
    public TaskQueryService taskQueryService(final TaskRepositoryImpl taskRepository) {
        return new TaskQueryService(taskRepository);
    }

    @Bean
    public TaskCommandService taskCommandService(final TaskRepositoryImpl taskRepository) {
        return new TaskCommandService(taskRepository, taskCreateCommandToTaskConverter(), taskUpdateCommandToTaskConverter());
    }

    @Bean
    public TopicService topicService(final TopicRepository topicRepository) {
        return new TopicService(topicRepository);
    }
}
