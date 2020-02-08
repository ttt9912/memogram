package ch.ttt.memogram.domain.motive;

import lombok.Value;

import java.util.UUID;

@Value
public class MotiveKey {
    private final String id;

    public static MotiveKey generate() {
        return new MotiveKey(UUID.randomUUID().toString());
    }

    public static MotiveKey from(final String uuid) {
        return new MotiveKey(uuid);
    }
}
