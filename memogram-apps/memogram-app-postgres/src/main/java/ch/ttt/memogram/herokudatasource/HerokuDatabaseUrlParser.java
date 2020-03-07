package ch.ttt.memogram.herokudatasource;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class HerokuDatabaseUrlParser {
    public static final String JDBC_POSTGRESQL = "jdbc:postgresql://";

    public static String createJdbcUrl(final String herokuDatabaseUrl, final List<String> options) {
        return createJdbcUrl(parseHerokuUrl(herokuDatabaseUrl), options);
    }

    private static HerokuJdbcCredentials parseHerokuUrl(final String herokuDatabaseUrl) {
        final String[] split = herokuDatabaseUrl.split("@");
        final String server = split[1];
        final String credentials = split[0].replace("postgres://", "");
        final String[] split1 = credentials.split(":");
        final String username = split1[0];
        final String password = split1[1];
        return new HerokuJdbcCredentials(server, username, password);
    }

    private static String createJdbcUrl(final HerokuJdbcCredentials credentials, final List<String> options) {
        return JDBC_POSTGRESQL.concat(credentials.getServer())
                .concat("?user=").concat(credentials.getUsername())
                .concat("&password=").concat(credentials.getPassword())
                .concat("&").concat(createOptions(options));
    }

    private static String createOptions(final List<String> options) {
        return String.join("&", options);
    }

}
