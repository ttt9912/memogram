package ch.ttt.memogram.datajpa.deadline;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.datajpa.motive.MotiveEntityFactory;
import ch.ttt.memogram.datajpa.motive.MotiveFactory;
import ch.ttt.memogram.datajpa.motive.MotiveJpaRepository;
import ch.ttt.memogram.domain.deadline.Deadline;
import ch.ttt.memogram.domain.motive.Motive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class DeadlineRepositoryImpl implements DomainRepository<Deadline> {

    @Override
    public List<Deadline> findAll() {
        log.error("not implemented");
        return null;
    }

    @Override
    public void save(final Deadline deadline) {
        log.error("not implemented");
    }
}
