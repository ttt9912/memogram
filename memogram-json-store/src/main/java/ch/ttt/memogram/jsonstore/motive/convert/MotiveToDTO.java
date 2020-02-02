package ch.ttt.memogram.jsonstore.motive.convert;

import ch.ttt.memogram.domain.motive.Motive;
import ch.ttt.memogram.jsonstore.common.Converter;
import ch.ttt.memogram.jsonstore.motive.MotiveJsonDTO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface MotiveToDTO extends Converter<Motive, MotiveJsonDTO> {

    @Override
    MotiveJsonDTO convert(Motive element);
}
