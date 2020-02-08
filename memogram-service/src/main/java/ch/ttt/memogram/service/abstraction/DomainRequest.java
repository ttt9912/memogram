package ch.ttt.memogram.service.abstraction;

public interface DomainRequest<KEY, COMMAND> {
    KEY getKey();

    COMMAND getCommand();
}
