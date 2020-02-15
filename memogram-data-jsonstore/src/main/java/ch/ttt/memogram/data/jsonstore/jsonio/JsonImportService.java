package ch.ttt.memogram.data.jsonstore.jsonio;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
public class JsonImportService {
    public static final String CLASSPATH_FILESTORE = "classpath:filestore/";
    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    public JsonImportService(final ResourceLoader resourceLoader, final ObjectMapper objectMapper) {
        this.resourceLoader = resourceLoader;
        this.objectMapper = objectMapper;
    }

    public <DTO> List<DTO> readFile(final String path, final Class<DTO> type) {
        final Resource resource = resourceLoader.getResource(CLASSPATH_FILESTORE + path);
        final JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, type);
        try {
            return objectMapper.readValue(resource.getInputStream(), javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
