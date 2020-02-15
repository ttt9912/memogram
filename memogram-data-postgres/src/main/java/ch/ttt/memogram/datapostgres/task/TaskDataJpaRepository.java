package ch.ttt.memogram.datapostgres.task;

import org.springframework.data.repository.CrudRepository;

public interface TaskDataJpaRepository extends CrudRepository<TaskEntity, String> {
}
