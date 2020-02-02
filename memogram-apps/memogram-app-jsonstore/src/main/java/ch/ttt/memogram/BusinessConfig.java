package ch.ttt.memogram;

import ch.ttt.memogram.business.abstractions.DomainRepository;
import ch.ttt.memogram.business.appointment.AppointmentService;
import ch.ttt.memogram.business.deadline.DeadlineService;
import ch.ttt.memogram.business.motive.MotiveService;
import ch.ttt.memogram.domain.deadline.Deadline;
import ch.ttt.memogram.domain.motive.Motive;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BusinessConfig {

    @Bean
    public MotiveService motiveService(final DomainRepository<Motive> motiveRepository) {
        return new MotiveService(motiveRepository);
    }

    @Bean
    public DeadlineService deadlineService(final DomainRepository<Deadline> deadlineRepository) {
        return new DeadlineService(deadlineRepository);
    }

    @Bean
    public AppointmentService appointmentService() {
        return new AppointmentService(null);
    }
}
