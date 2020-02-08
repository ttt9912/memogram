package ch.ttt.memogram.business.abstraction.query;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.domain.abstraction.DomainEntity;

import java.util.Collection;

public abstract class DomainQueryService<KEY, ENTITY extends DomainEntity<KEY>> {
    private final DomainRepository<KEY, ENTITY> repository;

    protected DomainQueryService(final DomainRepository<KEY, ENTITY> repository) {
        this.repository = repository;
    }

    public Collection<ENTITY> findAll() {
        return repository.findAll();
    }
}
