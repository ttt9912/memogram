package ch.ttt.memogram.service.topic;

import ch.ttt.memogram.business.topic.TopicService;
import ch.ttt.memogram.domain.topic.Note;
import ch.ttt.memogram.domain.topic.Topic;
import ch.ttt.memogram.domain.topic.TopicKey;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/topics")
public class TopicController {
    private final TopicService topicService;

    public TopicController(final TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping
    public List<Topic> findAll() throws InterruptedException {
        Thread.sleep(1000);
        return topicService.find();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> findByKey(@PathVariable final String id) throws InterruptedException {
        Thread.sleep(1000);
        return topicService.find(new TopicKey(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/deleted")
    public List<Topic> findDeleted() {
        return topicService.findDeleted();
    }

    @PostMapping
    public TopicKey create(@RequestBody final String title) {
        return topicService.createAndSave(title);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final String id) {
        topicService.delete(new TopicKey(id));
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable final String id, @RequestBody final String note) {
        topicService.addNote(new TopicKey(id), new Note(note));
    }
}