package ch.ttt.memogram.business.topic;

import ch.ttt.memogram.business.abstraction.DomainCRUDService;
import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.domain.topic.Note;
import ch.ttt.memogram.domain.topic.Topic;
import ch.ttt.memogram.domain.topic.TopicKey;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopicService extends DomainCRUDService<TopicKey, Topic> {
    private final DomainRepository<TopicKey, Topic> repository;

    public TopicService(final DomainRepository<TopicKey, Topic> repository) {
        super(repository);
        this.repository = repository;
    }


    public TopicKey createAndSave(final String title) {
        final Topic topic = createTopic(title, TopicKey.generate(), Collections.emptyList());
        repository.save(topic);
        return topic.getKey();
    }

    public void addNote(final TopicKey key, final Note note) {
        final Topic existing = repository.findByKey(key).orElseThrow(() -> new RuntimeException("Topic does not exist"));
        final Topic topic = createTopic(existing.getTitle(), existing.getKey(), combine(existing.getNotes(), note));
        repository.save(topic);
    }

    private Topic createTopic(final String title, final TopicKey key, final List<Note> objects) {
        final Topic topic = new Topic(key);
        topic.setTitle(title);
        topic.setNotes(objects);
        return topic;
    }

    private List<Note> combine(final List<Note> existing, final Note note) {
        return Stream.concat(existing.stream(), Stream.of(note))
                .collect(Collectors.toList());
    }
}
