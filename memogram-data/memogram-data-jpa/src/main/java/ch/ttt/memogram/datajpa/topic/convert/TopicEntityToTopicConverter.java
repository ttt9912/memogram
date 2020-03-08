package ch.ttt.memogram.datajpa.topic.convert;

import ch.ttt.memogram.datajpa.topic.TopicEntity;
import ch.ttt.memogram.domain.topic.Note;
import ch.ttt.memogram.domain.topic.Topic;
import ch.ttt.memogram.domain.topic.TopicKey;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TopicEntityToTopicConverter implements Converter<TopicEntity, Topic> {

    @Override
    public Topic convert(final TopicEntity element) {
        return new Topic(convertKey(element.getId()), element.getTitle(),
                Converter.convertList(element.getNotes(), Note::new));
    }

    private TopicKey convertKey(final String id) {
        return new TopicKey(id);
    }

}
