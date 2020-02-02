package ch.ttt.memogram.service.deadline;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class DeadlineDTO {
    private String uuid;
    private final String title;
    private final LocalDateTime deadline;
}
