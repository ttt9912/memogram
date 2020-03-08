package ch.ttt.memogram.data.jsonstore.topic.convert;

import ch.ttt.memogram.data.jsonstore.topic.TopicJsonElement;
import ch.ttt.memogram.domain.topic.Note;
import ch.ttt.memogram.domain.topic.Topic;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TopicToTopicJsonElementConverter implements Converter<Topic, TopicJsonElement> {

    @Override
    public TopicJsonElement convert(final Topic element) {
        return new TopicJsonElement(element.getKey().getId(),
                element.getTitle(),
                Converter.convertList(element.getNotes(), Note::getText));
    }
}
