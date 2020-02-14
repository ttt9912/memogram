package ch.ttt.memogram.business.task.query;

import ch.ttt.memogram.business.abstraction.DomainRepository;
import ch.ttt.memogram.business.abstraction.query.DomainQueryService;
import ch.ttt.memogram.domain.abstraction.UUIDKey;
import ch.ttt.memogram.domain.task.Task;

public class TaskQueryService extends DomainQueryService<UUIDKey, Task> {

    public TaskQueryService(final DomainRepository<UUIDKey, Task> repository) {
        super(repository);
    }

}
