package ch.ttt.memogram.jsonstore.blocker.converter;

import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.jsonstore.blocker.BlockerJsonElement;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BlockerJsonElementToUUIDKeyConverter implements Converter<BlockerJsonElement, UUIDKey> {

    @Override
    public UUIDKey convert(final BlockerJsonElement element) {
        return UUIDKey.from(element.getId());
    }
}
