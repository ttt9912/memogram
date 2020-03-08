package ch.ttt.memogram.domain.topic;

import ch.ttt.memogram.domain.abstraction.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Topic implements DomainEntity<TopicKey> {
    private final TopicKey key;
    private String title;
    private List<Note> notes;
}
