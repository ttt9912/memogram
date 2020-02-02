package ch.ttt.memogram.jsonstore.deadline.convert;

import ch.ttt.memogram.domain.deadline.Deadline;
import ch.ttt.memogram.jsonstore.abstractions.Converter;
import ch.ttt.memogram.jsonstore.deadline.DeadlineJsonDTO;
import org.mapstruct.Mapper;

@Mapper
public interface DeadlineToDTO extends Converter<Deadline, DeadlineJsonDTO> {
}
