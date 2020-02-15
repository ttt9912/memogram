package ch.ttt.memogram.datajpa.task;

import ch.ttt.memogram.datajpa.abstraction.DomainRepositoryImpl;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepositoryImpl extends DomainRepositoryImpl<UUIDKey, Task, String, TaskEntity> {

    public TaskRepositoryImpl(final CrudRepository<TaskEntity, String> repository,
                              final Converter<TaskEntity, Task> taskEntityTaskConverter,
                              final Converter<Task, TaskEntity> ormEntityConverter,
                              final Converter<UUIDKey, String> idConverter) {
        super(repository, taskEntityTaskConverter, ormEntityConverter, idConverter);
    }
}
