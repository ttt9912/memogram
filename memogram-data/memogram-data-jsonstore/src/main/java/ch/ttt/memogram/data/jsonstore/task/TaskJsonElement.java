package ch.ttt.memogram.data.jsonstore.task;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class TaskJsonElement {
    private String id;
    private String title;
    private LocalDateTime deadline;
    private List<String> tags;
}
