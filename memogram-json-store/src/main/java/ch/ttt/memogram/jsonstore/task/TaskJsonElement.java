package ch.ttt.memogram.jsonstore.task;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class TaskJsonElement {
    private String id;
    private String title;
    private LocalDateTime deadline;

    /*
    @JsonCreator
    public TaskJsonElement(@JsonProperty("id") final String id,
                           @JsonProperty("title") final String title,
                           @JsonProperty("deadline") final LocalDateTime deadline) {
        this.id = id;
        this.title = title;
        this.deadline = deadline;
    }*/
}
