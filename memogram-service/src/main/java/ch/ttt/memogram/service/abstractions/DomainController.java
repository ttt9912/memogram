package ch.ttt.memogram.service.abstractions;

import ch.ttt.memogram.business.abstractions.DomainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class DomainController<ENTITY> {
    private final DomainService<ENTITY> service;

    protected DomainController(final DomainService<ENTITY> service) {
        this.service = service;
    }

    @GetMapping
    public List<ENTITY> findAll() {
        return service.findAll();
    }

    @PostMapping
    public void create(@RequestBody final ENTITY entity) {
        service.save(entity);
    }
}
