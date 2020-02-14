package ch.ttt.memogram.domain.appointment;

import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.shared.Timebox;
import lombok.Data;

@Data
public class Appointment implements DomainEntity<UUIDKey> {
    private final UUIDKey key;
    private String title;
    private Timebox timebox;
}
