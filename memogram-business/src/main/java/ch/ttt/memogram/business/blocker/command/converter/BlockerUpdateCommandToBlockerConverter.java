package ch.ttt.memogram.business.blocker.command.converter;

import ch.ttt.memogram.business.blocker.command.BlockerUpdateCommand;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.blocker.Blocker;
import ch.ttt.memogram.shared.converter.Converter;

public class BlockerUpdateCommandToBlockerConverter implements Converter<BlockerUpdateCommand, Blocker> {

    @Override
    public Blocker convert(final BlockerUpdateCommand element) {
        return new Blocker(UUIDKey.from(element.getUuid()), element.getTitle(), element.getOptions());
    }
}
