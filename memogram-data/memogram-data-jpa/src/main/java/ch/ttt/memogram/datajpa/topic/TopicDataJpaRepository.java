package ch.ttt.memogram.datajpa.topic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicDataJpaRepository extends CrudRepository<TopicEntity, String> {
}