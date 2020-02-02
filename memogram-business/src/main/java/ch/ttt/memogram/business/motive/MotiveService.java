package ch.ttt.memogram.business.motive;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.domain.motive.Motive;

import java.util.List;

public class MotiveService {
    private final DomainRepository<Motive> motiveRepository;

    public MotiveService(final DomainRepository<Motive> motiveRepository) {
        this.motiveRepository = motiveRepository;
    }

    public List<Motive> findAll() {
        return motiveRepository.findAll();
    }

    public void save(final Motive motive) {
        motiveRepository.save(motive);
    }
}
