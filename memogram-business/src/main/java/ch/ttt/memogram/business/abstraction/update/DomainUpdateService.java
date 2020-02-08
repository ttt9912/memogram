package ch.ttt.memogram.business.abstraction.update;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.exception.BusinessException;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.shared.converter.Converter;

public abstract class DomainUpdateService<KEY, ENTITY extends DomainEntity<KEY>, UPDATE_COMMAND> {
    private final DomainRepository<KEY, ENTITY> repository;
    private final Converter<UPDATE_COMMAND, ENTITY> entityConverter;
    private final Converter<UPDATE_COMMAND, KEY> keyConverter;

    protected DomainUpdateService(final DomainRepository<KEY, ENTITY> repository,
                                  final Converter<UPDATE_COMMAND, ENTITY> entityConverter, final Converter<UPDATE_COMMAND, KEY> keyConverter) {
        this.repository = repository;
        this.entityConverter = entityConverter;
        this.keyConverter = keyConverter;
    }

    public void update(final UPDATE_COMMAND command) {
        repository.findByKey(keyConverter.convert(command)).ifPresentOrElse(
                existing -> repository.save(entityConverter.convert(command)),
                this::throwException);
    }

    private void throwException() {
        throw new BusinessException("Entity does not exists");
    }
}
