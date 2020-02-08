package ch.ttt.memogram.domain.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
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
}
