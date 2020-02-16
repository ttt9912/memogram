package ch.ttt.memogram;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/*
 * run local postgres & pgAdmin (docker)
 * - Notes: memogram-data-jpa-postgres/local-postgres
 *
 * VM Options: -Dspring.profiles.active=dev
 */
@SpringBootApplication
public class MemogramPostgresApp {

    public static void main(final String[] args) {
        SpringApplication.run(MemogramPostgresApp.class, args);
    }

    @Bean
    CommandLineRunner run(Environment environment) {
        return args -> {
            System.out.println("--------------------- env ---------------------");
            System.out.printf("Profiles: %s\n", environment.getActiveProfiles());
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
}
