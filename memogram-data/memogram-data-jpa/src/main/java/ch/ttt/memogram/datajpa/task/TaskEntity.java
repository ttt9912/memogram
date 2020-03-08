package ch.ttt.memogram.datajpa.task;

import ch.ttt.memogram.datajpa.abstraction.ORMEntity;
import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Data
@Entity
public class TaskEntity extends ORMEntity {
    @Id
    private String uuid;
    private String title;
    private LocalDateTime deadline;

    @ElementCollection(fetch = EAGER)
    private List<String> tags;
}