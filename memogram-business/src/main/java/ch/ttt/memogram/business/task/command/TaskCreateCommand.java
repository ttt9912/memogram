package ch.ttt.memogram.business.task.command;

import ch.ttt.memogram.domain.tag.Tag;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class TaskCreateCommand {
    private final String title;
    private final LocalDateTime deadline;
    private List<Tag> tags;
}
