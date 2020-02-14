package ch.ttt.memogram.business.abstraction.command;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.exception.BusinessException;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.shared.converter.Converter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainCommandService<KEY, ENTITY extends DomainEntity<KEY>, CREATE_COMMAND, UPDATE_COMMAND> {
    private final DomainRepository<KEY, ENTITY> repository;
    private final Converter<CREATE_COMMAND, ENTITY> createEntityConverter;
    private final Converter<UPDATE_COMMAND, ENTITY> updateEntityConverter;

    public void delete(final KEY key) {
        repository.remove(key);
    }

    public void create(final CREATE_COMMAND command) {
        repository.save(createEntityConverter.convert(command));
    }

    public void update(final UPDATE_COMMAND command) {
        final ENTITY entity = updateEntityConverter.convert(command);
        repository.findByKey(entity.getKey()).ifPresentOrElse(
                existing -> repository.save(entity),
                this::throwException);
    }

    private void throwException() {
        throw new BusinessException("Entity does not exists");
    }
}
