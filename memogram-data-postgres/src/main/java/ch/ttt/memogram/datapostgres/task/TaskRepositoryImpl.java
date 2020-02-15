package ch.ttt.memogram.datapostgres.task;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.datapostgres.util.RepositoryUtil;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class TaskRepositoryImpl implements DomainRepository<UUIDKey, Task> {
    private final TaskDataJpaRepository dataJpaRepository;

    public TaskRepositoryImpl(final TaskDataJpaRepository dataJpaRepository) {
        this.dataJpaRepository = dataJpaRepository;
    }

    @Override
    public List<Task> findAll() {
        return RepositoryUtil.toList(dataJpaRepository.findAll()).stream()
                .map(this::createTask)
                .collect(Collectors.toList());
    }

    private Task createTask(final TaskEntity taskEntity) {
        return new Task(UUIDKey.from(taskEntity.getId()), taskEntity.getTitle(), taskEntity.getDeadline());
    }

    @Override
    public void save(final Task entity) {
        dataJpaRepository.save(createTaskEntity(entity));
    }

    private TaskEntity createTaskEntity(final Task entity) {
        final TaskEntity taskEntity = new TaskEntity(); // TODO: mapstruct
        taskEntity.setId(entity.getKey().getId());
        taskEntity.setTitle(entity.getTitle());
        taskEntity.setDeadline(entity.getDeadline());
        return taskEntity;
    }

    @Override
    public Optional<Task> findByKey(final UUIDKey uuidKey) {
        return dataJpaRepository.findById(uuidKey.getId())
                .map(this::createTask);
    }

    @Override
    public void remove(final UUIDKey uuidKey) {
        dataJpaRepository.deleteById(uuidKey.getId());
    }
}
