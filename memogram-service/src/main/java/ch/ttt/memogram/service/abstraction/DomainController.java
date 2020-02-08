package ch.ttt.memogram.service.abstraction;

import ch.ttt.memogram.business.abstraction.create.DomainCreateService;
import ch.ttt.memogram.business.abstraction.delete.DomainDeleteService;
import ch.ttt.memogram.business.abstraction.query.DomainQueryService;
import ch.ttt.memogram.business.abstraction.update.DomainUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public abstract class DomainController<KEY, ENTITY, CREATE_COMMAND, UPDATE_COMMAND, DTO> {
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
    public void create(@RequestBody final DomainRequest<KEY, CREATE_COMMAND> request) {
        createService.create(request.getKey(), request.getCommand());
    }

    @PutMapping
    public void update(@RequestBody final DomainRequest<KEY, UPDATE_COMMAND> request) {
        updateService.update(request.getKey(), request.getCommand());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable final String id) {
        deleteService.delete(keyConverter.convert(id));
    }
}
