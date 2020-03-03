package ch.ttt.memogram.data.jsonstore.topic;

import ch.ttt.memogram.data.jsonstore.abstraction.DomainRepositoryImpl;
import ch.ttt.memogram.data.jsonstore.abstraction.JsonFileStore;
import ch.ttt.memogram.domain.topic.Topic;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class TopicRepository extends DomainRepositoryImpl<UUID, Topic> {

    protected TopicRepository(final JsonFileStore<UUID, Topic> store) {
        super(store);
    }
}
