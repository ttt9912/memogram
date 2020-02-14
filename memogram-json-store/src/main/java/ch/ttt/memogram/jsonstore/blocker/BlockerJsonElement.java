package ch.ttt.memogram.jsonstore.blocker;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Value
public class BlockerJsonElement implements Serializable {
    private String id;
    private String title;
    private List<TimeboxJsonElement> options;
}
