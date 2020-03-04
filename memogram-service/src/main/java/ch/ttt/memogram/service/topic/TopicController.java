package ch.ttt.memogram.service.topic;

import ch.ttt.memogram.business.topic.TopicService;
import ch.ttt.memogram.domain.topic.Note;
import ch.ttt.memogram.domain.topic.Topic;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/topics")
public class TopicController {
    private final TopicService topicService;
    private final ObjectMapper objectMapper;

    public TopicController(final TopicService topicService, final ObjectMapper objectMapper) {
        this.topicService = topicService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<Topic> findAll() throws InterruptedException {
        Thread.sleep(1000);
        return topicService.findAll();
    }

    @GetMapping("/{key}")
    public ResponseEntity<Topic> findByKey(@PathVariable final UUID key) throws InterruptedException {
        Thread.sleep(1000);
        return topicService.findByKey(key)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UUID create(@RequestBody final String title) {
        return topicService.createAndSave(title);
    }

    @PutMapping
    public void update(@RequestBody final Topic topic) {
        topicService.save(topic);
    }

    @PatchMapping("/{key}")
    public void update(@PathVariable final UUID key, @RequestBody final Note note) {
        topicService.addNote(key, note);
    }

}