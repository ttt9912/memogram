package ch.ttt.memogram.service.abstraction;

import ch.ttt.memogram.business.abstraction.create.DomainCreateService;
import ch.ttt.memogram.business.abstraction.delete.DomainDeleteService;
import ch.ttt.memogram.business.abstraction.query.DomainQueryService;
import ch.ttt.memogram.business.abstraction.update.DomainUpdateService;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.shared.converter.Converter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainCrudController<KEY, ENTITY extends DomainEntity<KEY>, CREATE_COMMAND, UPDATE_COMMAND, DTO> {
    private final DomainQueryService<KEY, ENTITY> queryService;
    private final DomainCreateService<KEY, ENTITY, CREATE_COMMAND> createService;
    private final DomainUpdateService<KEY, ENTITY, UPDATE_COMMAND> updateService;
    private final DomainDeleteService<KEY, ENTITY> deleteService;
    private final Converter<ENTITY, DTO> dtoConverter;
    private final Converter<String, KEY> keyConverter;

    @GetMapping
    public List<DTO> findAll() {
        return dtoConverter.convertAll(queryService.findAll());
    }

    @PostMapping()
    public void create(@RequestBody final CREATE_COMMAND command) {
        createService.create(command);
    }

    @PutMapping
    public void update(@RequestBody final UPDATE_COMMAND command) {
        updateService.update(command);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable final String id) {
        deleteService.delete(keyConverter.convert(id));
    }
}
