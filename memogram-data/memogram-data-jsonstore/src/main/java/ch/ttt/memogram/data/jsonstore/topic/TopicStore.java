package ch.ttt.memogram.data.jsonstore.topic;

import ch.ttt.memogram.data.jsonstore.abstraction.JsonFileStore;
import ch.ttt.memogram.domain.topic.Topic;
import ch.ttt.memogram.domain.topic.TopicKey;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TopicStore extends JsonFileStore<TopicKey, Topic, TopicJsonElement> {

    protected TopicStore(final Converter<Topic, TopicJsonElement> jsonConverter,
                         final Converter<TopicJsonElement, Topic> entityConverter,
                         final Converter<TopicJsonElement, TopicKey> keyConverter) {
        super(jsonConverter, entityConverter, keyConverter);
    }

    @Override
    protected Class<TopicJsonElement> getJsonElementClass() {
        return null;
    }
}
