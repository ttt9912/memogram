package ch.ttt.memogram.service.abstractions;

import ch.ttt.memogram.business.abstractions.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RequiredArgsConstructor
public abstract class DomainController<ENTITY, DTO> {
    private final DomainService<ENTITY> service;
    private final Converter<DTO, ENTITY> entityConverter;
    private final Converter<ENTITY, DTO> dtoConverter;

    @GetMapping
    public List<DTO> findAll() {
        return dtoConverter.convertAll(service.findAll());
    }

    @PostMapping
    public void create(@RequestBody final DTO dto) {
        service.save(entityConverter.convert(dto));
    }
}
