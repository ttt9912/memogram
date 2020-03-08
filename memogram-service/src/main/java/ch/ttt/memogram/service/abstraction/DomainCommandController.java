package ch.ttt.memogram.service.abstraction;

import ch.ttt.memogram.business.abstraction.command.DomainCommandService;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.shared.converter.Converter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class DomainCommandController<KEY, ENTITY extends DomainEntity<KEY>, CREATE_COMMAND, UPDATE_COMMAND> {
    private final DomainCommandService<KEY, ENTITY, CREATE_COMMAND, UPDATE_COMMAND> commandService;
    private final Converter<String, KEY> keyConverter;

    @PostMapping
    public void create(@RequestBody final CREATE_COMMAND command) {
        commandService.create(command);
    }

    @PutMapping
    public void update(@RequestBody final UPDATE_COMMAND command) {
        commandService.update(command);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable final String id) {
        commandService.delete(keyConverter.convert(id));
    }
}
