package ch.ttt.memogram.jsonstore;

import ch.ttt.memogram.domain.motive.Motive;
import ch.ttt.memogram.jsonstore.motive.MotiveJsonDTO;
import ch.ttt.memogram.jsonstore.motive.convert.DTOToMotive;
import ch.ttt.memogram.jsonstore.motive.convert.MotiveToDTO;
import ch.ttt.memogram.jsonstore.store.JsonStore;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonStoreConfig {

    @Bean
    public JsonStore<Motive, MotiveJsonDTO> motiveStore() {
        return new JsonStore<>(MotiveJsonDTO.class,
                new DTOToMotive(),
                Mappers.getMapper(MotiveToDTO.class));
    }

}
