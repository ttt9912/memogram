package ch.ttt.memogram.datajpa.abstraction;

import lombok.Data;

import javax.persistence.MappedSuperclass;

// TODO: Auditing & order lists by last modified
@Data
@MappedSuperclass
public abstract class ORMEntity {
    private Boolean deleted;
}
