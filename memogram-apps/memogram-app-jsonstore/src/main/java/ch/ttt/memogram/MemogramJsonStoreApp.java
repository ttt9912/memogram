package ch.ttt.memogram;

import ch.ttt.memogram.business.task.create.TaskCreateCommand;
import ch.ttt.memogram.business.task.create.TaskCreateService;
import ch.ttt.memogram.business.task.query.TaskQueryService;
import ch.ttt.memogram.domain.task.TaskKey;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class MemogramJsonStoreApp {

    public static void main(final String[] args) {
        SpringApplication.run(MemogramJsonStoreApp.class, args);
    }

    @Bean
    CommandLineRunner runner(final TaskQueryService service, final TaskCreateService createService) {
        return args -> {
            createService.create(TaskKey.generate(), new TaskCreateCommand("Learn Spring", LocalDateTime.now()));
            service.findAll().forEach(System.out::println);
        };
    }
}