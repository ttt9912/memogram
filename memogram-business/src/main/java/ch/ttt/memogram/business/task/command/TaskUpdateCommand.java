package ch.ttt.memogram.business.task.command;

import ch.ttt.memogram.domain.tag.Tag;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class TaskUpdateCommand {
    private String uuid;
    private String title;
    private LocalDateTime deadline;
    private List<Tag> tags;
}
