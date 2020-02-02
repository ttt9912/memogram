package ch.ttt.memogram.service.deadline;

import ch.ttt.memogram.business.abstractions.DomainService;
import ch.ttt.memogram.domain.deadline.Deadline;
import ch.ttt.memogram.service.abstractions.DomainController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deadlines")
public class DeadlineController extends DomainController<Deadline> {

    public DeadlineController(final DomainService<Deadline> service) {
        super(service);
    }
}
