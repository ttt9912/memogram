package ch.ttt.memogram.business.abstractions;

import java.util.Collection;
import java.util.Optional;

public interface DomainRepository<ENTITY, KEY> {
    Collection<ENTITY> findAll();

    void save(ENTITY entity);

    Optional<ENTITY> findByKey(KEY key);
}
