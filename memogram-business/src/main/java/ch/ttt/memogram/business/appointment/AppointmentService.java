package ch.ttt.memogram.business.appointment;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.domain.appointment.Appointment;

import java.util.List;

public class AppointmentService {
    private final DomainRepository<Appointment> appointmentRepository;

    public AppointmentService(final DomainRepository<Appointment> appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public void save(final Appointment motive) {
        appointmentRepository.save(motive);
    }
}
