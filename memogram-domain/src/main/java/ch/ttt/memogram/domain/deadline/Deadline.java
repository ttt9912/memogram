package ch.ttt.memogram.domain.deadline;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Deadline {
    private final String title;
    private final LocalDateTime deadline;
}
