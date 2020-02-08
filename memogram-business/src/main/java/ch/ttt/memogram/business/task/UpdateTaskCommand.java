package ch.ttt.memogram.business.task;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class UpdateTaskCommand {
    private String uuid;
    private String title;
    private LocalDateTime deadline;
}
