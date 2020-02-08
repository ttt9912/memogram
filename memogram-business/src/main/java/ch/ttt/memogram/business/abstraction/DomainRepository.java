package ch.ttt.memogram.business.abstraction;

import ch.ttt.memogram.domain.abstraction.DomainEntity;

import java.util.Collection;
import java.util.Optional;

public interface DomainRepository<KEY, ENTITY extends DomainEntity<KEY>> {
    Collection<ENTITY> findAll();

    void save(ENTITY entity);

    Optional<ENTITY> findByKey(KEY key);

    void remove(KEY key);
}
