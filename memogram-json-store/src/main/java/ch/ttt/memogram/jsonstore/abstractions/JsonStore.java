package ch.ttt.memogram.jsonstore.abstractions;

import ch.ttt.memogram.jsonstore.common.JsonExportService;
import ch.ttt.memogram.jsonstore.common.JsonImportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class JsonStore<ENTITY, DTO> {
    private final List<DTO> store = new ArrayList<>();

    private final Class<DTO> dtoType;
    private final Converter<DTO, ENTITY> entityConverter;
    private final Converter<ENTITY, DTO> dtoConverter;

    @Autowired
    private JsonImportService jsonImportService;

    @Autowired
    private JsonExportService jsonExportService;

    @PostConstruct
    public void init() {
        log.info("init Store {}", this.getClass().getSimpleName());
        store.addAll(jsonImportService.readFile(getFilename(), dtoType));
    }

    public final void save(final ENTITY entity) {
        store.add(dtoConverter.convert(entity));
        persist();
    }

    public List<ENTITY> get() {
        return entityConverter.convertAll(List.copyOf(store));
    }

    public String getFilename() {
        return String.join(".", dtoType.getSimpleName().toLowerCase(), "json");
    }

    private void persist() {
        jsonExportService.writeFile(getFilename(), store);
    }
}
