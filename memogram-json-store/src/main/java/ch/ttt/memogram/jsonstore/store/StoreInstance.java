package ch.ttt.memogram.jsonstore.store;

import ch.ttt.memogram.domain.motive.Motive;
import ch.ttt.memogram.jsonstore.motive.MotiveJsonDTO;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * TODO
 * - manage files
 * - init
 * - persist on shutdown
 * - manage dtos <Entity, Dto>
 */
public class StoreInstance {
    public static final List<MotiveJsonDTO> MOTIVES = new ArrayList<>();

    public void persist() {

    }

    public void init() {
        
    }
}
