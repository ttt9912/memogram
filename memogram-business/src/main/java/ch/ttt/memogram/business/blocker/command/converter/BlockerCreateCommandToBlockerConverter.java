package ch.ttt.memogram.business.blocker.command.converter;

import ch.ttt.memogram.business.blocker.command.BlockerCreateCommand;
import ch.ttt.memogram.domain.blocker.Blocker;
import ch.ttt.memogram.shared.converter.Converter;

public class BlockerCreateCommandToBlockerConverter implements Converter<BlockerCreateCommand, Blocker> {

    @Override
    public Blocker convert(final BlockerCreateCommand element) {
        return Blocker.from(element.getTitle(), element.getOptions());
    }
}
