package ch.ttt.memogram.data.jsonstore.abstraction;

import ch.ttt.memogram.domain.abstraction.DomainEntity;

public interface JsonElement<KEY, ENTITY extends DomainEntity<KEY>> {

    static <KEY, ENTITY extends DomainEntity<KEY>> JsonElement<KEY, ENTITY> create(final ENTITY entity) {
        return null;
    }

    ENTITY createEntity();

    KEY createKey();
}
