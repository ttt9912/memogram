package ch.ttt.memogram.data.jsonstore.abstraction;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainRepositoryImpl<KEY, ENTITY extends DomainEntity<KEY>, JSON_DTO> implements DomainRepository<KEY, ENTITY> {
    private final JsonFileStore<KEY, ENTITY, JSON_DTO> store;

    @Override
    public List<ENTITY> find() {
        return findEntities(false);
    }

    @Override
    public Optional<ENTITY> find(final KEY key) {
        return findEntity(key, false);
    }

    @Override
    public List<ENTITY> findDeleted() {
        return findEntities(true);
    }

    @Override
    public Optional<ENTITY> findDeleted(final KEY key) {
        return findEntity(key, true);
    }

    @Override
    public void save(final ENTITY entity) {
        store.save(entity);
    }

    private List<ENTITY> findEntities(final boolean deleted) {
        final List<ENTITY> entities = store.values().stream()
                .filter(deleted(deleted))
                .collect(Collectors.toList());
        return List.copyOf(entities);
    }

    private Optional<ENTITY> findEntity(final KEY key, final boolean deleted) {
        return store.value(key)
                .filter(deleted(deleted));
    }

    private Predicate<? super ENTITY> deleted(final boolean deleted) {
        return entity -> entity.getDeleted().equals(deleted);
    }
}
