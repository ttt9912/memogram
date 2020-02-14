package ch.ttt.memogram.jsonstore.blocker;

import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.blocker.Blocker;
import ch.ttt.memogram.jsonstore.abstraction.DomainRepositoryImpl;
import ch.ttt.memogram.jsonstore.abstraction.JsonFileStore;
import org.springframework.stereotype.Repository;

@Repository
public class BlockerRepository extends DomainRepositoryImpl<UUIDKey, Blocker, BlockerJsonElement> {

    protected BlockerRepository(final JsonFileStore<UUIDKey, Blocker, BlockerJsonElement> store) {
        super(store);
    }
}
