package ch.ttt.memogram.jsonstore.blocker.converter;

import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.blocker.Blocker;
import ch.ttt.memogram.domain.shared.Timebox;
import ch.ttt.memogram.jsonstore.blocker.BlockerJsonElement;
import ch.ttt.memogram.jsonstore.blocker.TimeboxJsonElement;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BlockerJsonElementToBlockerConverter implements Converter<BlockerJsonElement, Blocker> {

    @Override
    public Blocker convert(final BlockerJsonElement element) {
        return new Blocker(UUIDKey.from(element.getId()),
                element.getTitle(),
                convertTimeBoxes(element.getOptions()));
    }

    private List<Timebox> convertTimeBoxes(final List<TimeboxJsonElement> options) {
        return options.stream()
                .map(this::convertTimeBox)
                .collect(Collectors.toList());
    }

    private Timebox convertTimeBox(final TimeboxJsonElement timeboxJsonElement) {
        return new Timebox(timeboxJsonElement.getStart(), timeboxJsonElement.getEnd());
    }
}
