package ch.ttt.memogram.business.abstractions;

import java.util.Collection;

public abstract class DomainService<ENTITY, KEY> {
    private final DomainRepository<ENTITY, KEY> repository;

    protected DomainService(final DomainRepository<ENTITY, KEY> repository) {
        this.repository = repository;
    }

    public Collection<ENTITY> findAll() {
        return repository.findAll();
    }
}
