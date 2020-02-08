package ch.ttt.memogram.service.deadline;

import ch.ttt.memogram.service.util.IDGenerator;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class TaskDTO {
    private final String id = IDGenerator.random();
    private final String title;
    private final LocalDateTime deadline;
}
