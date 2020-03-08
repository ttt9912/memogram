package ch.ttt.memogram.datajpa.abstraction;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public abstract class DomainRepositoryImpl<
        DOMAIN_KEY,
        DOMAIN_ENTITY extends DomainEntity<DOMAIN_KEY>,
        ORM_ID,
        ORM_ENTITY extends ORMEntity>
        extends EventStoreRepository<DOMAIN_KEY, DOMAIN_ENTITY, ORM_ID, ORM_ENTITY>
        implements DomainRepository<DOMAIN_KEY, DOMAIN_ENTITY> {

    private final CrudRepository<ORM_ENTITY, ORM_ID> repository;
    private final Converter<DOMAIN_ENTITY, ORM_ENTITY> ormEntityConverter;
    private final Converter<DOMAIN_KEY, ORM_ID> idConverter;

    public DomainRepositoryImpl(final CrudRepository<ORM_ENTITY, ORM_ID> repository,
                                final Converter<ORM_ENTITY, DOMAIN_ENTITY> entityConverter,
                                final Converter<DOMAIN_KEY, ORM_ID> idConverter,
                                final Converter<DOMAIN_ENTITY, ORM_ENTITY> ormEntityConverter) {
        super(repository, entityConverter, idConverter);
        this.repository = repository;
        this.ormEntityConverter = ormEntityConverter;
        this.idConverter = idConverter;
    }

    @Override
    public List<DOMAIN_ENTITY> find() {
        return findEntities(false);
    }

    @Override
    public Optional<DOMAIN_ENTITY> find(final DOMAIN_KEY domainKey) {
        return findEntity(domainKey, false);
    }

    @Override
    public void save(final DOMAIN_ENTITY domainEntity) {
        repository.save(ormEntityConverter.convert(domainEntity));
    }
}
