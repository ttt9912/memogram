package ch.ttt.memogram.domain.topic;

import lombok.Value;

import java.util.UUID;

@Value
public class TopicKey {
    private final String id;

    public static TopicKey generate() {
        return new TopicKey(UUID.randomUUID().toString());
    }
}
