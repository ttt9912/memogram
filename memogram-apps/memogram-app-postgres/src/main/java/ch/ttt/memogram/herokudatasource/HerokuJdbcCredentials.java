package ch.ttt.memogram.herokudatasource;

import lombok.Value;

@Value
public class HerokuJdbcCredentials {
    private final String server;
    private final String username;
    private final String password;
}
