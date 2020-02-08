package ch.ttt.memogram.service.abstractions;

import ch.ttt.memogram.business.abstractions.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
public abstract class DomainController<ENTITY, KEY, DTO> {
    private final DomainService<ENTITY, KEY> service;
    private final Converter<DTO, ENTITY> entityConverter;
    private final Converter<ENTITY, DTO> dtoConverter;

    @GetMapping
    public List<DTO> findAll() {
        return dtoConverter.convertAll(service.findAll());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable final String id) {

    }
}
