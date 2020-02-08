package ch.ttt.memogram.domain.task;

import lombok.Value;

import java.util.UUID;

@Value
public class TaskKey {
    private final String id;

    public static TaskKey generate() {
        return new TaskKey(UUID.randomUUID().toString());
    }

    public static TaskKey from(final String uuid) {
        return new TaskKey(uuid);
    }
}
