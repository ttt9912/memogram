package ch.ttt.memogram.service.abstraction;

import ch.ttt.memogram.business.abstraction.query.DomainQueryService;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.shared.converter.Converter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainQueryController<KEY, ENTITY extends DomainEntity<KEY>, DTO> {
    private final DomainQueryService<KEY, ENTITY> queryService;
    private final Converter<ENTITY, DTO> dtoConverter;

    @GetMapping
    public List<DTO> findAll() throws InterruptedException {
        Thread.sleep(1000);
        return dtoConverter.convertAll(queryService.findAll());
    }
}
