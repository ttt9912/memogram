package ch.ttt.memogram.datajpa.abstraction;

import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.shared.converter.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;

@RequiredArgsConstructor
public class EventStoreRepository<
        DOMAIN_KEY,
        DOMAIN_ENTITY extends DomainEntity<DOMAIN_KEY>,
        ORM_ID,
        ORM_ENTITY extends ORMEntity> {

    private final CrudRepository<ORM_ENTITY, ORM_ID> repository;
    private final Converter<ORM_ENTITY, DOMAIN_ENTITY> entityConverter;
    private final Converter<DOMAIN_KEY, ORM_ID> idConverter;


}
