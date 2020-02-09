package ch.ttt.memogram.business.abstraction.create;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.shared.converter.Converter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainCreateService<KEY, ENTITY extends DomainEntity<KEY>, CREATE_COMMAND> {
    private final DomainRepository<KEY, ENTITY> repository;
    private final Converter<CREATE_COMMAND, ENTITY> entityConverter;

    public void create(final CREATE_COMMAND command) {
        repository.save(entityConverter.convert(command));
    }
}
