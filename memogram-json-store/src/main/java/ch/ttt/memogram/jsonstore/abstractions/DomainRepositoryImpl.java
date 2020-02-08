package ch.ttt.memogram.jsonstore.abstractions;

import ch.ttt.memogram.business.abstractions.DomainRepository;

import java.util.Collection;
import java.util.Optional;

public abstract class DomainRepositoryImpl<ENTITY, KEY, JSON_DTO> implements DomainRepository<ENTITY, KEY> {
    private final JsonFileStore<ENTITY, KEY, JSON_DTO> store;

    protected DomainRepositoryImpl(final JsonFileStore<ENTITY, KEY, JSON_DTO> store) {
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
