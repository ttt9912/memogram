package ch.ttt.memogram.data.jsonstore.abstraction;

import ch.ttt.memogram.data.jsonstore.jsonio.JsonExportService;
import ch.ttt.memogram.data.jsonstore.jsonio.JsonImportService;
import ch.ttt.memogram.domain.abstraction.DomainEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.*;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class JsonFileStore<KEY, ENTITY extends DomainEntity<KEY>> {
    private final Map<KEY, ENTITY> store = new HashMap<>();

    @Autowired
    private JsonImportService jsonImportService;

    @Autowired
    private JsonExportService jsonExportService;

    @PostConstruct
    public void init() {
        log.info("\n---------------------------------------" +
                        "\n init Store '{}'" +
                        "\n from file {}" +
                        "\n---------------------------------------"
                , this.getClass().getSimpleName(), getFilename());
        log.info("init Store {}", this.getClass().getSimpleName());

        read().forEach(entity -> store.put(entity.getKey(), entity));
    }

    public Collection<ENTITY> values() {
        return store.values();
    }

    public Optional<ENTITY> value(final KEY key) {
        return Optional.ofNullable(store.get(key));
    }

    public synchronized void save(final ENTITY entity) {
        store.put(entity.getKey(), entity);
        persist(store.values());
    }

    private void persist(final Collection<ENTITY> elements) {
        jsonExportService.writeFile(getFilename(), elements);
    }

    public void remove(final KEY key) {
        store.remove(key);
    }

    private List<ENTITY> read() {
        return jsonImportService.readFile(getFilename(), getEntityClass());
    }

    private String getFilename() {
        return String.join(".", getEntityClass().getSimpleName().toLowerCase(), "json");
    }

    protected abstract Class<ENTITY> getEntityClass();

}
