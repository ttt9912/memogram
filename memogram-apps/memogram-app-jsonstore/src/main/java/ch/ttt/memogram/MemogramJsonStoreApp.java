package ch.ttt.memogram;

import ch.ttt.memogram.business.motive.MotiveService;
import ch.ttt.memogram.domain.motive.Motive;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MemogramJsonStoreApp {

    public static void main(final String[] args) {
        SpringApplication.run(MemogramJsonStoreApp.class, args);
    }

    @Bean
    CommandLineRunner runner(final MotiveService motiveService) {
        return args -> {
            final List<Motive> all = motiveService.findAll();
            all.forEach(System.out::println);
        };
    }
}