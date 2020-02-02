package ch.ttt.memogram.business.abstractions;

import java.util.List;

public abstract class DomainService<ENTITY> {
    private final DomainRepository<ENTITY> repository;

    protected DomainService(final DomainRepository<ENTITY> repository) {
        this.repository = repository;
    }

    public List<ENTITY> findAll() {
        return repository.findAll();
    }

    public void save(final ENTITY entity) {
        repository.save(entity);
    }
}
