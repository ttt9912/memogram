package ch.ttt.memogram.jsonstore.deadline.convert;

import ch.ttt.memogram.domain.deadline.Deadline;
import ch.ttt.memogram.jsonstore.abstractions.Converter;
import ch.ttt.memogram.jsonstore.deadline.DeadlineJsonDTO;

public class DTOToDeadline implements Converter<DeadlineJsonDTO, Deadline> {

    @Override
    public Deadline convert(final DeadlineJsonDTO deadlineJsonDTO) {
        return new Deadline(
                deadlineJsonDTO.getTitle(),
                deadlineJsonDTO.getDeadline());
    }
}
