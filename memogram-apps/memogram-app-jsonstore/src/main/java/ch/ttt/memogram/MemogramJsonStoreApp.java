package ch.ttt.memogram;

import ch.ttt.memogram.data.jsonstore.topic.TopicRepository;
import ch.ttt.memogram.domain.topic.Note;
import ch.ttt.memogram.domain.topic.Topic;
import ch.ttt.memogram.domain.topic.TopicKey;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.List;

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
            topicRepository.save(topic);
        };
    }

    private Topic createDummyTopic() {
        final Topic topic = new Topic(TopicKey.generate(),
                "Test2",
                List.of(new Note("buy clothes"), new Note("buy socks")));
        return topic;
    }
}