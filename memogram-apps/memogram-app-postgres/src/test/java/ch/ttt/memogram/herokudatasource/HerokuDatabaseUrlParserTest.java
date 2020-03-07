package ch.ttt.memogram.herokudatasource;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

class HerokuDatabaseUrlParserTest {

    @Test
    void parseUrl() {
        final String herokuUrl = "postgres://rsahifemdogmth:895447174f65bc6b0abfcd09e734c6b1ce1dc363f5cd44889fb0e8a267f82cbf@ec2-184-72-236-57.compute-1.amazonaws.com:5432/dritngcbkq7ka";
        final List<String> options = List.of("sslmode=require");

        final String expectedJdbcUrl = "jdbc:postgresql://ec2-184-72-236-57.compute-1.amazonaws.com:5432/dritngcbkq7ka?user=rsahifemdogmth&password=895447174f65bc6b0abfcd09e734c6b1ce1dc363f5cd44889fb0e8a267f82cbf&sslmode=require";

        assertThat(HerokuDatabaseUrlParser.createJdbcUrl(herokuUrl, options),
                equalTo(expectedJdbcUrl));
    }
}