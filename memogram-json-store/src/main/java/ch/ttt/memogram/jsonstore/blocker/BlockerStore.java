package ch.ttt.memogram.jsonstore.blocker;

import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.blocker.Blocker;
import ch.ttt.memogram.jsonstore.abstraction.JsonFileStore;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BlockerStore extends JsonFileStore<UUIDKey, Blocker, BlockerJsonElement> {

    protected BlockerStore(final Converter<Blocker, BlockerJsonElement> jsonConverter,
                           final Converter<BlockerJsonElement, Blocker> entityConverter,
                           final Converter<BlockerJsonElement, UUIDKey> keyConverter) {
        super(jsonConverter, entityConverter, keyConverter);
    }

    @Override
    protected Class<BlockerJsonElement> getJsonElementClass() {
        return BlockerJsonElement.class;
    }
}
