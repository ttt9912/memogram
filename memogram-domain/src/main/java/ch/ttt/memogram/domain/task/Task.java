package ch.ttt.memogram.domain.task;

import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.tag.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "key", callSuper = true)
public class Task extends DomainEntity<UUIDKey> {
    private final UUIDKey key;
    private String title;
    private LocalDateTime deadline;
    private List<Tag> tags;
    private Boolean deleted;

    public static Task from(final String title, final LocalDateTime deadline, final List<Tag> tags) {
        return new Task(UUIDKey.generate(), title, deadline, tags, false);
    }
}
