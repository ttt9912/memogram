package ch.ttt.memogram.data.jsonstore.abstraction;

import ch.ttt.memogram.data.jsonstore.jsonio.JsonExportService;
import ch.ttt.memogram.data.jsonstore.jsonio.JsonImportService;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import ch.ttt.memogram.shared.converter.Converter;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class JsonFileStore<KEY, ENTITY extends DomainEntity<KEY>, JSON_ELEMENT> {
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

        read().forEach(jsonElement -> store.put(
                keyConverter.convert(jsonElement),
                entityConverter.convert(jsonElement))
        );
    }

    public Collection<ENTITY> values() {
        return store.values();
    }

    public Optional<ENTITY> value(final KEY key) {
        return Optional.ofNullable(store.get(key));
    }

    public synchronized void save(final ENTITY entity) {
        store.put(entity.getKey(), entity);
        persist(jsonConverter.convertAll(store.values()));
    }

    private void persist(final List<JSON_ELEMENT> elements) {
        log.info("\n---------------------------------------" +
                        "\n writing file '{}'" +
                        "\n---------------------------------------"
                , getFilename());
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
