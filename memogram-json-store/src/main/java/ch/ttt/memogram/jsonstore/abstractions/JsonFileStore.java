package ch.ttt.memogram.jsonstore.abstractions;

import ch.ttt.memogram.jsonstore.common.JsonExportService;
import ch.ttt.memogram.jsonstore.common.JsonImportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
public abstract class JsonFileStore<ENTITY, KEY, JSON_ELEMENT> {
    private final Map<KEY, ENTITY> store = new HashMap<>();

    @Autowired
    private JsonImportService jsonImportService;

    @Autowired
    private JsonExportService jsonExportService;

    private final Converter<ENTITY, JSON_ELEMENT> jsonConverter;
    private final Converter<JSON_ELEMENT, ENTITY> entityConverter;
    private final Converter<JSON_ELEMENT, KEY> keyConverter;

    @PostConstruct
    public void init() {
        log.info("\n---------------------------------------" +
                        "\n init Store '{}'" +
                        "\n from file {}" +
                        "\n---------------------------------------"
                , this.getClass().getSimpleName(), getFilename());
        log.info("init Store {}", this.getClass().getSimpleName());
        read().forEach(jsonElement -> store.put(keyConverter.convert(jsonElement), entityConverter.convert(jsonElement)));
    }

    public Collection<ENTITY> values() {
        return store.values();
    }

    public Optional<ENTITY> value(final KEY key) {
        return Optional.ofNullable(store.get(key));
    }

    public synchronized void save(final KEY key, final ENTITY entity) { // TODO: this is a usecase for DomainEntity abstract class (getKey())
        store.put(key, entity);
        persist(jsonConverter.convertAll(store.values()));
    }

    private void persist(final List<JSON_ELEMENT> elements) {
        jsonExportService.writeFile(getFilename(), elements);
    }

    public void remove(final KEY key) {
        store.remove(key);
    }

    private List<JSON_ELEMENT> read() {
        return jsonImportService.readFile(getFilename(), getJsonElementClass());
    }

    private String getFilename() {
        return String.join(".", getJsonElementClass().getSimpleName().toLowerCase(), "json");
    }

    protected abstract Class<JSON_ELEMENT> getJsonElementClass();

}
