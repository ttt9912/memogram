package ch.ttt.memogram.business.abstractions;

import java.util.List;

public interface DomainRepository<ENTITY> {
    List<ENTITY> findAll();

    void save(ENTITY entity);
}
