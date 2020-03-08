package ch.ttt.memogram.datajpa.topic;

import ch.ttt.memogram.datajpa.abstraction.DomainRepositoryImpl;
import ch.ttt.memogram.domain.topic.Topic;
import ch.ttt.memogram.domain.topic.TopicKey;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TopicRepository extends DomainRepositoryImpl<TopicKey, Topic, String, TopicEntity> {

    public TopicRepository(final CrudRepository<TopicEntity, String> repository, final Converter<TopicEntity, Topic> topicEntityTopicConverter, final Converter<TopicKey, String> topicKeyStringConverter, final Converter<Topic, TopicEntity> ormEntityConverter) {
        super(repository, topicEntityTopicConverter, topicKeyStringConverter, ormEntityConverter);
    }
}