package ch.ttt.memogram;

import ch.ttt.memogram.business.task.CreateTaskCommand;
import ch.ttt.memogram.business.task.TaskService;
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
    CommandLineRunner runner(final TaskService service) {
        return args -> {
            service.createTask(new CreateTaskCommand("Learn Spring", LocalDateTime.now()));
            service.findAll().forEach(System.out::println);
        };
    }
}