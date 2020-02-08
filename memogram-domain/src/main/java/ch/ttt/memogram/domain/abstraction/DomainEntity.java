package ch.ttt.memogram.domain.abstraction;

public interface DomainEntity<KEY> {
    KEY getKey();
}
