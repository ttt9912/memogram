package ch.ttt.memogram.jsonstore.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class JsonExportService {
    public static final String FILESTORE = "src/main/resources/filestore";
    private final ObjectMapper objectMapper;

    public JsonExportService(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public synchronized void writeFile(final String filename, final List<?> elements) {
        final File file = getOrCreateFile(Paths.get("memogram-json-store", FILESTORE, filename));
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
