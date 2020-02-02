package ch.ttt.memogram.datajpa.tag;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
public class TagEntity {
    @Id
    private String name;
}
