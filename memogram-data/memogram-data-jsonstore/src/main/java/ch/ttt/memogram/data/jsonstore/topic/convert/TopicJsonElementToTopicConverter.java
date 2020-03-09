package ch.ttt.memogram.data.jsonstore.topic.convert;

import ch.ttt.memogram.data.jsonstore.topic.TopicJsonElement;
import ch.ttt.memogram.domain.topic.Note;
import ch.ttt.memogram.domain.topic.Topic;
import ch.ttt.memogram.domain.topic.TopicKey;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TopicJsonElementToTopicConverter implements Converter<TopicJsonElement, Topic> {


    @Override
    public Topic convert(final TopicJsonElement element) {
        return new Topic(new TopicKey(element.getId()),
                element.getTitle(),
                Converter.convertList(element.getNotes(), Note::new)); // TODO: deleted property
    }
}
