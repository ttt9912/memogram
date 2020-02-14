package ch.ttt.memogram.domain.task;

import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "key")
public class Task implements DomainEntity<UUIDKey> {
    private final UUIDKey key;
    private String title;
    private LocalDateTime deadline;

    public static Task from(final String title, final LocalDateTime deadline) {
        return new Task(UUIDKey.generate(), title, deadline);
    }
}
