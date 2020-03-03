package ch.ttt.memogram;

import ch.ttt.memogram.data.jsonstore.topic.TopicRepository;
import ch.ttt.memogram.domain.topic.Note;
import ch.ttt.memogram.domain.topic.Topic;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class MemogramJsonStoreApp {

    public static void main(final String[] args) {
        SpringApplication.run(MemogramJsonStoreApp.class, args);
    }

    @Bean
    CommandLineRunner run(Environment environment) {
        return args -> {
            System.out.println("--------------------- env ---------------------");
            System.out.printf("DATABASE_URL: %s\n", environment.getProperty("DATABASE_URL"));
            System.out.printf("SPRING_DATASOURCE_URL: %s\n", environment.getProperty("SPRING_DATASOURCE_URL"));
            System.out.printf("SPRING_DATASOURCE_USERNAME: %s\n", environment.getProperty("SPRING_DATASOURCE_USERNAME"));
            System.out.printf("SPRING_DATASOURCE_PASSWORD: %s\n", environment.getProperty("SPRING_DATASOURCE_PASSWORD"));

            System.out.printf("JDBC_DATABASE_URL: %s\n", environment.getProperty("JDBC_DATABASE_URL"));
            System.out.printf("JDBC_DATABASE_USERNAME: %s\n", environment.getProperty("JDBC_DATABASE_USERNAME"));
            System.out.printf("JDBC_DATABASE_PASSWORD: %s\n", environment.getProperty("JDBC_DATABASE_PASSWORD"));
            System.out.println("-----------------------------------------------");
        };
    }

    @Bean
    CommandLineRunner data(TopicRepository topicRepository) {
        return args -> {
            topicRepository.findAll().forEach(System.out::println);

            final Topic topic = createDummyTopic();
            // topicRepository.save(topic);
        };
    }

    private Topic createDummyTopic() {
        final Note note1 = new Note();
        note1.setText("buy clothes");
        final Note note2 = new Note();
        note2.setText("buy socks");
        final Topic topic = new Topic();
        topic.setKey(UUID.randomUUID());
        topic.setTitle("Test2");
        topic.setNotes(List.of(note1, note2));
        return topic;
    }
}