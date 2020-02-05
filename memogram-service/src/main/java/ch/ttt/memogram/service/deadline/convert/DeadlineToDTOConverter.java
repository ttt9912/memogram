package ch.ttt.memogram.service.deadline.convert;

import ch.ttt.memogram.domain.deadline.Deadline;
import ch.ttt.memogram.service.abstractions.Converter;
import ch.ttt.memogram.service.deadline.DeadlineDTO;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeadlineToDTOConverter implements Converter<Deadline, DeadlineDTO> {

    @Override
    public DeadlineDTO convert(final Deadline deadline) {
        return new DeadlineDTO(
                UUID.randomUUID().toString(),
                deadline.getTitle(),
                deadline.getDeadline());
    }
}
