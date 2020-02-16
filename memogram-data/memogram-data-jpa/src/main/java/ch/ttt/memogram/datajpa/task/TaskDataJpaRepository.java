package ch.ttt.memogram.datajpa.task;

import org.springframework.data.repository.CrudRepository;

public interface TaskDataJpaRepository extends CrudRepository<TaskEntity, String> {
}
