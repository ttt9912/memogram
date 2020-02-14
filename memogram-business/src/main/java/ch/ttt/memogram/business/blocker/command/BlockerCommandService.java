package ch.ttt.memogram.business.blocker.command;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.abstraction.command.DomainCommandService;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.blocker.Blocker;
import ch.ttt.memogram.shared.converter.Converter;

public class BlockerCommandService extends DomainCommandService<UUIDKey, Blocker, BlockerCreateCommand, BlockerUpdateCommand> {

    public BlockerCommandService(final DomainRepository<UUIDKey, Blocker> repository,
                                 final Converter<BlockerCreateCommand, Blocker> createEntityConverter,
                                 final Converter<BlockerUpdateCommand, Blocker> updateEntityConverter) {
        super(repository, createEntityConverter, updateEntityConverter);
    }
}
