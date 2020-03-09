package ch.ttt.memogram.business.abstraction;

import ch.ttt.memogram.business.exception.BusinessException;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainService<KEY, ENTITY extends DomainEntity<KEY>> {
    private final DomainRepository<KEY, ENTITY> repository;

    public List<ENTITY> find() {
        return repository.find();
    }

    public Optional<ENTITY> find(final KEY key) {
        return repository.find(key);
    }

    public List<ENTITY> findDeleted() {
        return repository.findDeleted();
    }

    public Optional<ENTITY> findDeleted(final KEY key) {
        return repository.findDeleted(key);
    }

    public void delete(final KEY key) {
        repository.find(key).ifPresentOrElse(
                this::setDeleted,
                this::throwException);
    }

    private void setDeleted(final ENTITY entity) {
        entity.setDeleted(true);
        repository.save(entity);
    }

    private void throwException() {
        throw new BusinessException("Entity does not exists");
    }

    public void save(final ENTITY entity) {
        repository.save(entity);
    }
}
