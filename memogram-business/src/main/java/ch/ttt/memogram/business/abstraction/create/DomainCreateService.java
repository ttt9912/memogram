package ch.ttt.memogram.business.abstraction.create;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.shared.converter.Converter;

public abstract class DomainCreateService<KEY, ENTITY extends DomainEntity<KEY>, CREATE_COMMAND> {
    private final DomainRepository<KEY, ENTITY> repository;
    private final Converter<CREATE_COMMAND, ENTITY> entityConverter;

    protected DomainCreateService(final DomainRepository<KEY, ENTITY> repository,
                                  final Converter<CREATE_COMMAND, ENTITY> entityConverter) {
        this.repository = repository;
        this.entityConverter = entityConverter;
    }

    public void create(final CREATE_COMMAND command) {
        repository.save(entityConverter.convert(command));
    }
}
