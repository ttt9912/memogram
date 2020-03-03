package ch.ttt.memogram.domain.topic;

import ch.ttt.memogram.domain.abstraction.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic implements DomainEntity<UUID> {
    private UUID key;
    private String title;
    private List<Note> notes;
}
