package ch.ttt.memogram.datajpa.motive;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.domain.motive.Motive;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MotiveRepositoryImpl implements DomainRepository<Motive> {
    private final MotiveJpaRepository motiveJpaRepository;

    public MotiveRepositoryImpl(final MotiveJpaRepository motiveJpaRepository) {
        this.motiveJpaRepository = motiveJpaRepository;
    }

    @Override
    public List<Motive> findAll() {
        return motiveJpaRepository.findAll().stream()
                .map(MotiveFactory::createMotive)
                .collect(Collectors.toList());
    }

    @Override
    public void save(final Motive motive) {
        motiveJpaRepository.save(MotiveEntityFactory.createMotiveEntity(motive));
    }
}
