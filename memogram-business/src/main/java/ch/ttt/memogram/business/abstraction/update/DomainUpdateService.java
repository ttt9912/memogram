package ch.ttt.memogram.business.abstraction.update;

import ch.ttt.memogram.business.abstraction.Converter;
import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.exception.BusinessException;

public abstract class DomainUpdateService<KEY, ENTITY, UPDATE_COMMAND> {
    private final DomainRepository<KEY, ENTITY> repository;
    private final Converter<UPDATE_COMMAND, ENTITY> entityConverter;

    protected DomainUpdateService(final DomainRepository<KEY, ENTITY> repository,
                                  final Converter<UPDATE_COMMAND, ENTITY> entityConverter) {
        this.repository = repository;
        this.entityConverter = entityConverter;
    }

    public void update(final KEY key, final UPDATE_COMMAND command) { // TODO: this is a usecase for DomainUpdateCommand abstract class (getKey())
        repository.findByKey(key).ifPresentOrElse(
                existing -> repository.save(key, entityConverter.convert(command)),
                this::throwException);
    }

    private void throwException() {
        throw new BusinessException("Entity does not exists");
    }
}
