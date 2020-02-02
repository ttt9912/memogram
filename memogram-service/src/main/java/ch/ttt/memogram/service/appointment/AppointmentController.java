package ch.ttt.memogram.service.appointment;

import ch.ttt.memogram.business.abstractions.DomainService;
import ch.ttt.memogram.domain.appointment.Appointment;
import ch.ttt.memogram.service.abstractions.DomainController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointments")
public class AppointmentController extends DomainController<Appointment> {

    public AppointmentController(final DomainService<Appointment> service) {
        super(service);
    }
}
