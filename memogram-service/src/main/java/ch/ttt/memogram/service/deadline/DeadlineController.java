package ch.ttt.memogram.service.deadline;

import ch.ttt.memogram.business.deadline.DeadlineService;
import ch.ttt.memogram.domain.deadline.Deadline;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deadlines")
public class DeadlineController {
    private final DeadlineService deadlineService;

    public DeadlineController(final DeadlineService deadlineService) {
        this.deadlineService = deadlineService;
    }

    @GetMapping
    public List<Deadline> findAll() {
        return deadlineService.findAll();
    }

    @PostMapping
    public void create(@RequestBody final Deadline deadline) {
        deadlineService.save(deadline);
    }
}
