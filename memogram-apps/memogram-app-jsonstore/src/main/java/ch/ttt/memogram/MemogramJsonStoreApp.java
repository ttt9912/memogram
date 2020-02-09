package ch.ttt.memogram;

import ch.ttt.memogram.business.task.create.TaskCreateService;
import ch.ttt.memogram.business.task.query.TaskQueryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/*
 * TODO
 *  - Motive Tags: https://getbootstrap.com/docs/4.4/components/badge/
 *
 */
@SpringBootApplication
public class MemogramJsonStoreApp {

    public static void main(final String[] args) {
        SpringApplication.run(MemogramJsonStoreApp.class, args);
    }

    @Bean
    CommandLineRunner runner(final TaskQueryService service, final TaskCreateService createService) {
        return args -> {
            service.findAll().forEach(System.out::println);
        };
    }
}