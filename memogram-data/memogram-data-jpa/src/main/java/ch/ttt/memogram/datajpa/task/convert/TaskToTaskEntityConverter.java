package ch.ttt.memogram.datajpa.task.convert;

import ch.ttt.memogram.datajpa.task.TaskEntity;
import ch.ttt.memogram.domain.task.Task;
import ch.ttt.memogram.shared.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskToTaskEntityConverter implements Converter<Task, TaskEntity> {

    // TODO: mapstruct
    @Override
    public TaskEntity convert(final Task element) {
        final TaskEntity taskEntity = new TaskEntity();
        taskEntity.setUuid(element.getKey().getId());
        taskEntity.setTitle(element.getTitle());
        taskEntity.setDeadline(element.getDeadline());
        taskEntity.setDeleted(element.getDeleted());
        return taskEntity;
    }
}
