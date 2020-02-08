package ch.ttt.memogram.business.abstraction.create;

import ch.ttt.memogram.business.abstraction.Converter;
import ch.ttt.memogram.business.abstraction.DomainRepository;

public abstract class DomainCreateService<KEY, ENTITY, CREATE_COMMAND> {
    private final DomainRepository<KEY, ENTITY> repository;
    private final Converter<CREATE_COMMAND, ENTITY> entityConverter;

    protected DomainCreateService(final DomainRepository<KEY, ENTITY> repository,
                                  final Converter<CREATE_COMMAND, ENTITY> entityConverter) {
        this.repository = repository;
        this.entityConverter = entityConverter;
    }

    public void create(final KEY key, final CREATE_COMMAND command) { // TODO: this is a usecase for DomainUpdateCommand abstract class (getKey())
        final ENTITY entity = entityConverter.convert(command);
        repository.save(key, entity);
    }
}
