package ch.ttt.memogram.domain.topic;

import ch.ttt.memogram.domain.abstraction.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "key", callSuper = true)
public class Topic extends DomainEntity<TopicKey> {
    private final TopicKey key;
    private String title;
    private List<Note> notes;
    // TODO: @NonNull (maybe on super?)
    private Boolean deleted;
}
