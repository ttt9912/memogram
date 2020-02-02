package ch.ttt.memogram.jsonstore.deadline;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.domain.deadline.Deadline;
import ch.ttt.memogram.jsonstore.abstractions.JsonStore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeadlineRepositoryImpl implements DomainRepository<Deadline> {
    private final JsonStore<Deadline, DeadlineJsonDTO> deadlineJsonStore;

    public DeadlineRepositoryImpl(final JsonStore<Deadline, DeadlineJsonDTO> deadlineJsonStore) {
        this.deadlineJsonStore = deadlineJsonStore;
    }

    @Override
    public List<Deadline> findAll() {
        return deadlineJsonStore.get();
    }

    @Override
    public void save(final Deadline deadline) {
        deadlineJsonStore.save(deadline);
    }
}
