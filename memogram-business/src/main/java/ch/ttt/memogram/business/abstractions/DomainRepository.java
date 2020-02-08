package ch.ttt.memogram.business.abstractions;

import java.util.Collection;
import java.util.Optional;

public interface DomainRepository<ENTITY, KEY> {
    Collection<ENTITY> findAll();

    void save(KEY key, ENTITY entity); // TODO: usecase for abstract DomainEntity..

    Optional<ENTITY> findByKey(KEY key);

    void remove(KEY key);
}
