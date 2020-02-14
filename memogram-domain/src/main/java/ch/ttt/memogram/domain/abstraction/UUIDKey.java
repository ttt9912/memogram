package ch.ttt.memogram.domain.abstraction;

import lombok.Value;

import java.util.UUID;

@Value
public class UUIDKey {
    private final String id;

    public static UUIDKey generate() {
        return new UUIDKey(UUID.randomUUID().toString());
    }

    public static UUIDKey from(final String uuid) {
        return new UUIDKey(uuid);
    }
}
