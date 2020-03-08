package ch.ttt.memogram.data.jsonstore.topic;

import ch.ttt.memogram.data.jsonstore.abstraction.JsonElement;
import ch.ttt.memogram.domain.topic.Note;
import ch.ttt.memogram.domain.topic.Topic;
import ch.ttt.memogram.domain.topic.TopicKey;
import ch.ttt.memogram.shared.converter.Converter;
import lombok.Value;

import java.util.List;

@Value
public class TopicJsonElement implements JsonElement<TopicKey, Topic> {
    private final String id;
    private String title;
    private List<String> notes;

    public static TopicJsonElement create(final Topic topic) {
        return new TopicJsonElement(
                topic.getKey().getId(),
                topic.getTitle(),
                Converter.convertList(topic.getNotes(), Note::getText));
    }

    public Topic createEntity() {
        return new Topic(new TopicKey(this.getId()), this.getTitle(),
                Converter.convertList(this.getNotes(), Note::new),
                false); // TODO: deleted field on jsonelement
    }

    public TopicKey createKey() {
        return new TopicKey(this.getId());
    }
}
