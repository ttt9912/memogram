package ch.ttt.memogram.datajpa.appointment;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.domain.appointment.Appointment;
import ch.ttt.memogram.domain.deadline.Deadline;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class AppointmentRepositoryImpl implements DomainRepository<Appointment> {

    @Override
    public List<Appointment> findAll() {
        log.error("not implemented");
        return null;
    }

    @Override
    public void save(final Appointment appointment) {
        log.error("not implemented");
    }
}
