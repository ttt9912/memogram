package ch.ttt.memogram.business.abstraction;

import ch.ttt.memogram.domain.abstraction.DomainEntity;

import java.util.List;
import java.util.Optional;

public interface DomainRepository<KEY, ENTITY extends DomainEntity<KEY>> {
    List<ENTITY> find();

    Optional<ENTITY> find(KEY key);

    List<ENTITY> findDeleted();

    Optional<ENTITY> findDeleted(KEY key);

    void save(ENTITY entity);

    // TODO
    // delete(id)
    // restore(id)
    // remove(id) noop
}
