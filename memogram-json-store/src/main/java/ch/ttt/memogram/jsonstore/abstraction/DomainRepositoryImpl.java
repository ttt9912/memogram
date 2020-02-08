package ch.ttt.memogram.jsonstore.abstraction;

import ch.ttt.memogram.business.abstraction.DomainRepository;

import java.util.Collection;
import java.util.Optional;

public abstract class DomainRepositoryImpl<KEY, ENTITY, JSON_DTO> implements DomainRepository<KEY, ENTITY> {
    private final JsonFileStore<KEY, ENTITY, JSON_DTO> store;

    protected DomainRepositoryImpl(final JsonFileStore<KEY, ENTITY, JSON_DTO> store) {
        this.store = store;
    }

    @Override
    public Collection<ENTITY> findAll() {
        return store.values();
    }

    @Override
    public void save(final KEY key, final ENTITY entity) { // TODO: usecase for abstract DomainEntity..
        store.save(key, entity);
    }

    @Override
    public Optional<ENTITY> findByKey(final KEY key) {
        return store.value(key);
    }

    @Override
    public void remove(final KEY key) {
        store.remove(key);
    }
}
