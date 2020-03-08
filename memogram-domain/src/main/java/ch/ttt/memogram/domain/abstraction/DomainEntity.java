package ch.ttt.memogram.domain.abstraction;

import lombok.Data;

@Data
public abstract class DomainEntity<KEY> {
    public abstract Boolean getDeleted();

    public abstract void setDeleted(final Boolean deleted);

    public abstract KEY getKey();
}
