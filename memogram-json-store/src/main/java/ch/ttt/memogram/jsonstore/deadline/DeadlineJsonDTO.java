package ch.ttt.memogram.jsonstore.deadline;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeadlineJsonDTO {
    private String title;
    private LocalDateTime deadline;
}
