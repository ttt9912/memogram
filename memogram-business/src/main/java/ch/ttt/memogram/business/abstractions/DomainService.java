package ch.ttt.memogram.business.abstractions;

import ch.ttt.memogram.business.exception.BusinessException;

import java.util.Collection;

public abstract class DomainService<ENTITY, KEY> {
    private final DomainRepository<ENTITY, KEY> repository;

    protected DomainService(final DomainRepository<ENTITY, KEY> repository) {
        this.repository = repository;
    }

    public Collection<ENTITY> findAll() {
        return repository.findAll();
    }

    protected void create(final KEY key, final ENTITY entity) {
        repository.save(key, entity);
    }

    protected void update(final KEY key, final ENTITY entity) { // TODO: this is a usecase for DomainEntity abstract class (getKey())
        repository.findByKey(key).ifPresentOrElse(
                existing -> repository.save(key, entity),
                this::throwException);
    }

    private void throwException() {
        throw new BusinessException("Entity does not exists");
    }

    public void delete(final KEY key) {
        repository.remove(key);
    }
}
