package ch.ttt.memogram.datajpa.topic;

import ch.ttt.memogram.datajpa.abstraction.ORMEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class TopicEntity extends ORMEntity {

    @Id
    private String id;
    private String title;

    @ElementCollection(fetch = EAGER)
    private List<String> notes;
}
