package ch.ttt.memogram.business.appointment;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.business.abstractions.DomainService;
import ch.ttt.memogram.domain.appointment.Appointment;

public class AppointmentService extends DomainService<Appointment> {

    public AppointmentService(final DomainRepository<Appointment> repository) {
        super(repository);
    }
}
