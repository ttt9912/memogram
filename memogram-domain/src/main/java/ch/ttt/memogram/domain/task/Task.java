package ch.ttt.memogram.domain.task;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "key")
public class Task {
    private final TaskKey key;
    private String title;
    private LocalDateTime deadline;

    public static Task from(final String title, final LocalDateTime deadline) {
        return new Task(TaskKey.generate(),
                title,
                deadline);
    }

    public static Task from(final TaskKey key, final String title, final LocalDateTime deadline) {
        return new Task(key,
                title,
                deadline);
    }
}
