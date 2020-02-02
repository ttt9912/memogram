package ch.ttt.memogram.jsonstore.motive.convert;

import ch.ttt.memogram.domain.motive.Motive;
import ch.ttt.memogram.jsonstore.abstractions.Converter;
import ch.ttt.memogram.jsonstore.motive.MotiveJsonDTO;
import org.mapstruct.Mapper;

@Mapper
public interface MotiveToDTO extends Converter<Motive, MotiveJsonDTO> {
}
