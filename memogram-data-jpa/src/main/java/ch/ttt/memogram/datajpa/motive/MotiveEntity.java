package ch.ttt.memogram.datajpa.motive;

import ch.ttt.memogram.datajpa.tag.TagEntity;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class MotiveEntity {
    @Id
    private String title;
    private Boolean completed;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER) // TODO: what are they again?
    private List<TagEntity> tags;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime modified;
}
