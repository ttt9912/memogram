package ch.ttt.memogram.business.task.command;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class TaskUpdateCommand {
    private String uuid;
    private String title;
    private LocalDateTime deadline;
}
