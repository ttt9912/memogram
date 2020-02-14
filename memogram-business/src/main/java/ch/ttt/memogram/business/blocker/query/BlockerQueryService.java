package ch.ttt.memogram.business.blocker.query;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.abstraction.query.DomainQueryService;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.blocker.Blocker;

public class BlockerQueryService extends DomainQueryService<UUIDKey, Blocker> {

    public BlockerQueryService(final DomainRepository<UUIDKey, Blocker> repository) {
        super(repository);
    }
}
