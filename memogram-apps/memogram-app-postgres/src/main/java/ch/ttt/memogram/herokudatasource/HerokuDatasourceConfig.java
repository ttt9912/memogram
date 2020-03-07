package ch.ttt.memogram.herokudatasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.util.List;

@Profile("!local")
@Configuration
public class HerokuDatasourceConfig {

    @Value("${DATABASE_URL}")
    private String herokuDatabaseUrl;

    private static List<String> options() {
        return List.of("sslmode=require");
    }

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(HerokuDatabaseUrlParser.createJdbcUrl(herokuDatabaseUrl, options()))
                .build();
    }
}
