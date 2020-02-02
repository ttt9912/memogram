package ch.ttt.memogram.service.motive;

import ch.ttt.memogram.business.motive.MotiveService;
import ch.ttt.memogram.domain.motive.Motive;
import ch.ttt.memogram.service.abstractions.DomainController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/motives")
public class MotiveController extends DomainController<Motive> {

    public MotiveController(final MotiveService motiveService) {
        super(motiveService);
    }
}
