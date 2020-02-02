package ch.ttt.memogram.business.deadline;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.domain.deadline.Deadline;

import java.util.List;

public class DeadlineService {
    private final DomainRepository<Deadline> deadlineRepository;

    public DeadlineService(final DomainRepository<Deadline> deadlineRepository) {
        this.deadlineRepository = deadlineRepository;
    }

    public List<Deadline> findAll() {
        return deadlineRepository.findAll();
    }

    public void save(final Deadline deadline) {
        deadlineRepository.save(deadline);
    }
}
