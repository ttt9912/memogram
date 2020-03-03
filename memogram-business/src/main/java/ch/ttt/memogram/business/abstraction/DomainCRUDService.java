package ch.ttt.memogram.business.abstraction;

import ch.ttt.memogram.domain.abstraction.DomainEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainCRUDService<KEY, ENTITY extends DomainEntity<KEY>> {
    private final DomainRepository<KEY, ENTITY> repository;

    public List<ENTITY> findAll() {
        return repository.findAll();
    }

    public Optional<ENTITY> findByKey(final KEY key) {
        return repository.findByKey(key);
    }

    public void delete(final KEY key) {
        repository.remove(key);
    }

    public void save(final ENTITY entity) {
        repository.save(entity);
    }
}
