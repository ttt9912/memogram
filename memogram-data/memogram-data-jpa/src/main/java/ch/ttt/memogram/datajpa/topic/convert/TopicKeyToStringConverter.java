package ch.ttt.memogram.datajpa.topic.convert;

import ch.ttt.memogram.domain.topic.TopicKey;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TopicKeyToStringConverter implements Converter<TopicKey, String> {

    @Override
    public String convert(final TopicKey element) {
        return element.getId();
    }
}
