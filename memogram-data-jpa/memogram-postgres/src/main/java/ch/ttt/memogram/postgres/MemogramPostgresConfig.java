package ch.ttt.memogram.postgres;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:memogram-postgres.properties")
public class MemogramPostgresConfig {
}
