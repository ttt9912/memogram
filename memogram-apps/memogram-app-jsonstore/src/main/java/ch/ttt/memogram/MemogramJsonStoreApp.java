package ch.ttt.memogram;

import ch.ttt.memogram.business.blocker.command.BlockerCommandService;
import ch.ttt.memogram.business.blocker.command.BlockerCreateCommand;
import ch.ttt.memogram.business.blocker.query.BlockerQueryService;
import ch.ttt.memogram.business.task.command.TaskCommandService;
import ch.ttt.memogram.business.task.query.TaskQueryService;
import ch.ttt.memogram.domain.shared.Timebox;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;


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
    CommandLineRunner runner(final TaskQueryService service, final TaskCommandService commandService,
                             final BlockerQueryService blockerQueryService, final BlockerCommandService blockerCommandService) {
        return args -> {
            // commandService.create(new TaskCreateCommand("Buy Clothes", null));
            blockerCommandService.create(new BlockerCreateCommand("Wohnungsbesichtigung",
                    List.of(new Timebox(LocalDateTime.now(), LocalDateTime.now()))));

            blockerQueryService.findAll()
                    .forEach(System.out::println);
        };
    }
}