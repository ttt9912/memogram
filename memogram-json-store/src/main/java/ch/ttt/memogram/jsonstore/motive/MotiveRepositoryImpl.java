package ch.ttt.memogram.jsonstore.motive;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.domain.motive.Motive;
import ch.ttt.memogram.jsonstore.common.JsonStore;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotiveRepositoryImpl implements DomainRepository<Motive> {
    private final JsonStore<Motive, MotiveJsonDTO> motiveJsonStore;

    public MotiveRepositoryImpl(final JsonStore<Motive, MotiveJsonDTO> motiveJsonStore) {
        this.motiveJsonStore = motiveJsonStore;
    }

    @Override
    public List<Motive> findAll() {
        return motiveJsonStore.get();
    }

    @Override
    public void save(final Motive motive) {
        motiveJsonStore.save(motive);
    }
}
