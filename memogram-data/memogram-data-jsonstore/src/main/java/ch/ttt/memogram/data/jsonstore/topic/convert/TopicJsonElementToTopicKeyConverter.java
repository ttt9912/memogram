package ch.ttt.memogram.data.jsonstore.topic.convert;

import ch.ttt.memogram.data.jsonstore.topic.TopicJsonElement;
import ch.ttt.memogram.domain.topic.TopicKey;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TopicJsonElementToTopicKeyConverter implements Converter<TopicJsonElement, TopicKey> {

    @Override
    public TopicKey convert(final TopicJsonElement element) {
        return new TopicKey(element.getId());
    }
}
