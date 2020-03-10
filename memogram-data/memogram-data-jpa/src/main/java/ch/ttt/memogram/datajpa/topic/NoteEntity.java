package ch.ttt.memogram.datajpa.topic;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import java.time.LocalDateTime;

@Embeddable
@EntityListeners(AuditingEntityListener.class)
public class NoteEntity {
    private String text;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;
}
