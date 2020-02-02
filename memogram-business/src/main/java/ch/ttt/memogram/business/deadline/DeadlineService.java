package ch.ttt.memogram.business.deadline;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.business.abstractions.DomainService;
import ch.ttt.memogram.domain.deadline.Deadline;

public class DeadlineService extends DomainService<Deadline> {

    public DeadlineService(final DomainRepository<Deadline> repository) {
        super(repository);
    }
}
