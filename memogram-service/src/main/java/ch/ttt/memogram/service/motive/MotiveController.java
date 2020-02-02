package ch.ttt.memogram.service.motive;

import ch.ttt.memogram.business.motive.MotiveService;
import ch.ttt.memogram.domain.motive.Motive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motives")
public class MotiveController {
    private final MotiveService motiveService;

    public MotiveController(final MotiveService motiveService) {
        this.motiveService = motiveService;
    }

    @GetMapping
    public List<Motive> findAll() {
        return motiveService.findAll();
    }

    @PostMapping
    public void create(@RequestBody final Motive motive){
        motiveService.save(motive);
    }
}
