package ch.ttt.memogram;

import ch.ttt.memogram.business.task.command.TaskCommandService;
import ch.ttt.memogram.business.task.command.TaskCreateCommand;
import ch.ttt.memogram.business.task.query.TaskQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

/*
 * run local postgres & pgAdmin (docker)
 * - Notes: memogram-data-jpa/memogram-postgres/local-postgres
 */
@SpringBootApplication
public class MemogramPostgresApp {

    public static void main(final String[] args) {
        SpringApplication.run(MemogramPostgresApp.class, args);
    }

    @Bean
    CommandLineRunner run(TaskCommandService commandService, TaskQueryService queryService) {
        return args -> {
            commandService.create(new TaskCreateCommand("Clean", LocalDateTime.now()));
            queryService.findAll().forEach(System.out::println);
        };
    }
}
