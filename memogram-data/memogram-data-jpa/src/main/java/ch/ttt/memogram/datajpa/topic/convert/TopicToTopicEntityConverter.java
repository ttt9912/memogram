package ch.ttt.memogram.datajpa.topic.convert;

import ch.ttt.memogram.datajpa.topic.TopicEntity;
import ch.ttt.memogram.domain.topic.Note;
import ch.ttt.memogram.domain.topic.Topic;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TopicToTopicEntityConverter implements Converter<Topic, TopicEntity> {

    @Override
    public TopicEntity convert(final Topic element) {
        final TopicEntity topicEntity = new TopicEntity();
        topicEntity.setId(element.getKey().getId());
        topicEntity.setTitle(element.getTitle());
        topicEntity.setNotes(Converter.convertList(element.getNotes(), Note::getText));
        return topicEntity;
    }
}
