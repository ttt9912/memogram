package ch.ttt.memogram.data.jsonstore.abstraction;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainRepositoryImpl<KEY, ENTITY extends DomainEntity<KEY>, JSON_DTO> implements DomainRepository<KEY, ENTITY> {
    private final JsonFileStore<KEY, ENTITY, JSON_DTO> store;

    @Override
    public List<ENTITY> findAll() {
        return List.copyOf(store.values());
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
