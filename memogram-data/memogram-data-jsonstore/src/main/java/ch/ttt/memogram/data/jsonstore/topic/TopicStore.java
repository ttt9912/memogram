package ch.ttt.memogram.data.jsonstore.topic;

import ch.ttt.memogram.data.jsonstore.abstraction.JsonFileStore;
import ch.ttt.memogram.domain.topic.Topic;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TopicStore extends JsonFileStore<UUID, Topic> {

    @Override
    protected Class<Topic> getEntityClass() {
        return Topic.class;
    }
}
