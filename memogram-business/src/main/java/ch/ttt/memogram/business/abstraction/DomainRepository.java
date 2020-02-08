package ch.ttt.memogram.business.abstraction;

import java.util.Collection;
import java.util.Optional;

public interface DomainRepository<KEY, ENTITY> {
    Collection<ENTITY> findAll();

    void save(KEY key, ENTITY entity); // TODO: usecase for abstract DomainEntity..

    Optional<ENTITY> findByKey(KEY key);

    void remove(KEY key);
}
