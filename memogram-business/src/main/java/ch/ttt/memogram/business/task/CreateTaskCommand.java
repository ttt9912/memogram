package ch.ttt.memogram.business.task;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class CreateTaskCommand {
    private final String title;
    private final LocalDateTime deadline;
}
