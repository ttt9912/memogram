package ch.ttt.memogram;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AngularController {

    // @GetMapping({"/", "/tasks/**"})
    @GetMapping({"/", "/app/**"})
    public String forward() {
        return "forward:/index.html";
    }
}
