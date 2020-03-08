package ch.ttt.memogram.datajpa.task;

import ch.ttt.memogram.datajpa.abstraction.DomainRepositoryImpl;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepositoryImpl extends DomainRepositoryImpl<UUIDKey, Task, String, TaskEntity> {

    public TaskRepositoryImpl(final CrudRepository<TaskEntity, String> repository, final Converter<TaskEntity, Task> taskEntityTaskConverter, final Converter<UUIDKey, String> uuidKeyStringConverter, final Converter<Task, TaskEntity> ormEntityConverter) {
        super(repository, taskEntityTaskConverter, uuidKeyStringConverter, ormEntityConverter);
    }
}
