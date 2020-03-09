package ch.ttt.memogram.datajpa.task;

import ch.ttt.memogram.datajpa.abstraction.DomainRepositoryImpl;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepositoryImpl extends DomainRepositoryImpl<UUIDKey, Task, String, TaskEntity> {

    protected TaskRepositoryImpl(final CrudRepository<TaskEntity, String> repository, final Converter<Task, TaskEntity> ormEntityConverter, final Converter<UUIDKey, String> uuidKeyStringConverter, final Converter<TaskEntity, Task> entityConverter) {
        super(repository, ormEntityConverter, uuidKeyStringConverter, entityConverter);
    }
}
