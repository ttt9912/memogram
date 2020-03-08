package ch.ttt.memogram.business.abstraction.query;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainQueryService<KEY, ENTITY extends DomainEntity<KEY>> {
    private final DomainRepository<KEY, ENTITY> repository;

    public Collection<ENTITY> findAll() {
        return repository.find();
    }
}
