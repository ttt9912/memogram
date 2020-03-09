package ch.ttt.memogram.domain.abstraction;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class DomainEntity<KEY> {
    private Boolean deleted;
    private LocalDateTime created;
    private LocalDateTime modified;

    public abstract KEY getKey();
}
