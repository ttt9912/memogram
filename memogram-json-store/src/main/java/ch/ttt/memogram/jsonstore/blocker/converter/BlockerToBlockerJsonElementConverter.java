package ch.ttt.memogram.jsonstore.blocker.converter;

import ch.ttt.memogram.domain.blocker.Blocker;
import ch.ttt.memogram.domain.shared.Timebox;
import ch.ttt.memogram.jsonstore.blocker.BlockerJsonElement;
import ch.ttt.memogram.jsonstore.blocker.TimeboxJsonElement;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BlockerToBlockerJsonElementConverter implements Converter<Blocker, BlockerJsonElement> {


    @Override
    public BlockerJsonElement convert(final Blocker element) {
        return new BlockerJsonElement(element.getKey().getId(),
                element.getTitle(),
                convertTimeboxJsonElements(element.getOptions()));
    }

    private List<TimeboxJsonElement> convertTimeboxJsonElements(final List<Timebox> options) {
        return options.stream()
                .map(this::convertTimeboxJsonElement)
                .collect(Collectors.toList());
    }

    private TimeboxJsonElement convertTimeboxJsonElement(final Timebox timebox) {
        return new TimeboxJsonElement(timebox.getStart(), timebox.getEnd());
    }
}
