package ch.ttt.memogram.datajpa.topic;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class TopicEntity {

    @Id
    private String id;
    private String title;

    @ElementCollection
    private List<String> notes;
}
