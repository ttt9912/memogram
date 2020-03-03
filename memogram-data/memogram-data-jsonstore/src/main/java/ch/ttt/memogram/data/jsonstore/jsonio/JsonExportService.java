package ch.ttt.memogram.data.jsonstore.jsonio;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

@Slf4j
@Component
public class JsonExportService {
    public static final String FILESTORE = "src/main/resources/filestore";
    private final ObjectMapper objectMapper;

    public JsonExportService(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public synchronized void writeFile(final String filename, final Collection<?> elements) {
        final File file = getOrCreateFile(Paths.get("memogram-data/memogram-data-jsonstore", FILESTORE, filename));
        log.info("\n---------------------------------------" +
                        "\n writing file '{}'" +
                        "\n---------------------------------------"
                , file.getAbsolutePath());
        try {
            objectMapper.writeValue(file, elements);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private File getOrCreateFile(final Path path) {
        if (Files.exists(path)) {
            return path.toFile();
        }
        return createFile(path);
    }

    private File createFile(final Path path) {
        try {
            final File file = path.toFile();
            file.getParentFile().mkdirs();
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
