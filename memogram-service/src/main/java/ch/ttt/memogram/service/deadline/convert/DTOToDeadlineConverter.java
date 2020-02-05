package ch.ttt.memogram.service.deadline.convert;

import ch.ttt.memogram.domain.deadline.Deadline;
import ch.ttt.memogram.service.abstractions.Converter;
import ch.ttt.memogram.service.deadline.DeadlineDTO;
import org.springframework.stereotype.Component;

@Component
public class DTOToDeadlineConverter implements Converter<DeadlineDTO, Deadline> {

    @Override
    public Deadline convert(final DeadlineDTO element) {
        return new Deadline(
                element.getTitle(),
                element.getDeadline()
        );
    }
}
