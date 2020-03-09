package ch.ttt.memogram.datajpa.abstraction;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.shared.converter.Converter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainRepositoryImpl<KEY, ENTITY extends DomainEntity<KEY>,
        ORM_ID, ORM_ENTITY extends ORMEntity> implements DomainRepository<KEY, ENTITY> {

    private final CrudRepository<ORM_ENTITY, ORM_ID> repository;
    private final Converter<ENTITY, ORM_ENTITY> ormEntityConverter;
    private final Converter<KEY, ORM_ID> idConverter;
    private final Converter<ORM_ENTITY, ENTITY> entityConverter;

    @Override
    public List<ENTITY> find() {
        return findEntities(false);
    }

    @Override
    public Optional<ENTITY> find(final KEY domainKey) {
        return findEntity(domainKey, false);
    }

    public List<ENTITY> findDeleted() {
        return findEntities(true);
    }

    public Optional<ENTITY> findDeleted(final KEY key) {
        return findEntity(key, true);
    }

    protected List<ENTITY> findEntities(final boolean deleted) {
        return StreamSupport.stream(repository.findAll().spliterator(), true)
                .filter(deleted(deleted))
                .map(entityConverter::convert)
                .collect(Collectors.toList());
    }

    protected Optional<ENTITY> findEntity(final KEY key, final boolean deleted) {
        return repository.findById(idConverter.convert(key))
                .filter(deleted(deleted))
                .map(entityConverter::convert);
    }

    protected Predicate<? super ORM_ENTITY> deleted(final boolean deleted) {
        return entity -> entity.getDeleted() == null // TODO?
                || entity.getDeleted().equals(deleted);
    }

    @Override
    public void save(final ENTITY domainEntity) {
        repository.save(ormEntityConverter.convert(domainEntity));
    }
}
