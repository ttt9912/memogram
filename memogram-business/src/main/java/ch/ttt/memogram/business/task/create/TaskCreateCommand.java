package ch.ttt.memogram.business.task.create;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class TaskCreateCommand {
    private final String title;
    private final LocalDateTime deadline;
}
