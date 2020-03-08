package ch.ttt.memogram.data.jsonstore.topic;

import ch.ttt.memogram.data.jsonstore.abstraction.DomainRepositoryImpl;
import ch.ttt.memogram.data.jsonstore.abstraction.JsonFileStore;
import ch.ttt.memogram.domain.topic.Topic;
import ch.ttt.memogram.domain.topic.TopicKey;
import org.springframework.stereotype.Repository;

@Repository
public class TopicRepository extends DomainRepositoryImpl<TopicKey, Topic, TopicJsonElement> {

    protected TopicRepository(final JsonFileStore<TopicKey, Topic, TopicJsonElement> store) {
        super(store);
    }
}
