package ch.ttt.memogram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class RouteController {

    @GetMapping({"/home/**", "/start/**"})
    public String forward() {
        log.info("-------------------------");
        log.info("forwarding to index.html");
        log.info("-------------------------");
        return "forward:/index.html";
    }
}
