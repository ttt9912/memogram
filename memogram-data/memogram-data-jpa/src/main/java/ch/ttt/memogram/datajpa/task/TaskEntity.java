package ch.ttt.memogram.datajpa.task;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class TaskEntity {
    @Id
    private String uuid;
    private String title;
    private LocalDateTime deadline;

    @ElementCollection
    private List<String> tags;
}