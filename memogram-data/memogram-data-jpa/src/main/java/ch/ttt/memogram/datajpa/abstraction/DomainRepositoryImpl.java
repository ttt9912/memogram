package ch.ttt.memogram.datajpa.abstraction;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.shared.converter.Converter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainRepositoryImpl<DOMAIN_KEY, DOMAIN_ENTITY extends DomainEntity<DOMAIN_KEY>, ORM_ID, ORM_ENTITY>
        implements DomainRepository<DOMAIN_KEY, DOMAIN_ENTITY> {

    private final CrudRepository<ORM_ENTITY, ORM_ID> repository;
    private final Converter<ORM_ENTITY, DOMAIN_ENTITY> entityConverter;
    private final Converter<DOMAIN_ENTITY, ORM_ENTITY> ormEntityConverter;
    private final Converter<DOMAIN_KEY, ORM_ID> idConverter;

    @Override
    public List<DOMAIN_ENTITY> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), true)
                .map(entityConverter::convert)
                .collect(Collectors.toList());
    }

    @Override
    public void save(final DOMAIN_ENTITY domainEntity) {
        repository.save(ormEntityConverter.convert(domainEntity));
    }

    @Override
    public Optional<DOMAIN_ENTITY> findByKey(final DOMAIN_KEY domainKey) {
        return repository.findById(idConverter.convert(domainKey))
                .map(entityConverter::convert);
    }

    @Override
    public void remove(final DOMAIN_KEY domainKey) {
        repository.deleteById(idConverter.convert(domainKey));
    }
}
