package ch.ttt.memogram;

import ch.ttt.memogram.business.motive.MotiveService;
import ch.ttt.memogram.domain.motive.Motive;
import ch.ttt.memogram.domain.tag.Tag;
import ch.ttt.memogram.jsonstore.store.JsonExportService;
import ch.ttt.memogram.jsonstore.motive.MotiveJsonDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.List;

/*
 * -------------------------------------------------
 * H2 Console
 * -------------------------------------------------
 * http://localhost:8080/h2-console
 */
@SpringBootApplication
public class MemogramApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MemogramApplication.class, args);
    }

    @Bean
    @Order(1)
    CommandLineRunner runner(final MotiveService motiveService, ObjectMapper objectMapper, JsonExportService jsonExportService) {
        return args -> {
            final List<Motive> all = motiveService.findAll();
        };
    }
}
