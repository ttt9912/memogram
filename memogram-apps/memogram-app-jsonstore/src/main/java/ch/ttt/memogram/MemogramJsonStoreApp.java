package ch.ttt.memogram;

import ch.ttt.memogram.business.deadline.DeadlineService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MemogramJsonStoreApp {

    public static void main(final String[] args) {
        SpringApplication.run(MemogramJsonStoreApp.class, args);
    }

    @Bean
    CommandLineRunner runner(final DeadlineService service) {
        return args -> {
            service.findAll();
        };
    }
}