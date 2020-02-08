package ch.ttt.memogram.business.abstraction.delete;

import ch.ttt.memogram.business.abstraction.DomainRepository;

public abstract class DomainDeleteService<KEY, ENTITY> {
    private final DomainRepository<KEY, ENTITY> repository;

    protected DomainDeleteService(final DomainRepository<KEY, ENTITY> repository) {
        this.repository = repository;
    }

    public void delete(final KEY key) {
        repository.remove(key);
    }
}
