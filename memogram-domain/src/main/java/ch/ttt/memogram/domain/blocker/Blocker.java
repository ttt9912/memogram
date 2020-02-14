package ch.ttt.memogram.domain.blocker;

import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.shared.Timebox;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "key")
public class Blocker implements DomainEntity<UUIDKey> {
    private final UUIDKey key;
    private String title;
    private List<Timebox> options;

    public static Blocker from(final String title, final List<Timebox> options) {
        return new Blocker(UUIDKey.generate(), title, options);
    }
}
