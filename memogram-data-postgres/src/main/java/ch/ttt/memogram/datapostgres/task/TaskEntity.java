package ch.ttt.memogram.datapostgres.task;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class TaskEntity {

    @Id
    private String id;
    private String title;
    private LocalDateTime deadline;
}
