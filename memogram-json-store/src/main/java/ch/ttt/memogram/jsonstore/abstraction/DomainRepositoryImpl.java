package ch.ttt.memogram.jsonstore.abstraction;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainRepositoryImpl<KEY, ENTITY extends DomainEntity<KEY>, JSON_DTO> implements DomainRepository<KEY, ENTITY> {
    private final JsonFileStore<KEY, ENTITY, JSON_DTO> store;

    @Override
    public Collection<ENTITY> findAll() {
        return store.values();
    }

    @Override
    public void save(final ENTITY entity) {
        store.save(entity);
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
