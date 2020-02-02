package ch.ttt.memogram.business.motive;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.business.abstractions.DomainService;
import ch.ttt.memogram.domain.motive.Motive;
import ch.ttt.memogram.domain.tag.Tag;

import java.util.Collections;
import java.util.List;

public class MotiveService extends DomainService<Motive> {

    public MotiveService(final DomainRepository<Motive> repository) {
        super(repository);
    }

    public List<Motive> findByTag(final Tag tag) {
        return Collections.emptyList(); // TODO
    }
}
