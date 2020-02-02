package ch.ttt.memogram.service.appointment;

import ch.ttt.memogram.business.appointment.AppointmentService;
import ch.ttt.memogram.domain.appointment.Appointment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(final AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping
    public List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    @PostMapping
    public void create(@RequestBody final Appointment appointment) {
        appointmentService.save(appointment);
    }
}
