package ch.ttt.memogram.service.task;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class TaskDTO {
    private final String id;
    private final String title;
    private final LocalDateTime deadline;
}
