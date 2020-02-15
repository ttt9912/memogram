package ch.ttt.memogram.business.abstraction;

import ch.ttt.memogram.domain.abstraction.DomainEntity;

import java.util.List;
import java.util.Optional;

public interface DomainRepository<KEY, ENTITY extends DomainEntity<KEY>> {
    List<ENTITY> findAll();

    void save(ENTITY entity);

    Optional<ENTITY> findByKey(KEY key);

    void remove(KEY key);
}
