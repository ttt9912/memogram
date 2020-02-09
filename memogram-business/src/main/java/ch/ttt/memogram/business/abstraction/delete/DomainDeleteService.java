package ch.ttt.memogram.business.abstraction.delete;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainDeleteService<KEY, ENTITY extends DomainEntity<KEY>> {
    private final DomainRepository<KEY, ENTITY> repository;

    public void delete(final KEY key) {
        repository.remove(key);
    }
}
