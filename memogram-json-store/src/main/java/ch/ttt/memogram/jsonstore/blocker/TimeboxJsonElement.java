package ch.ttt.memogram.jsonstore.blocker;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

@Value
public class TimeboxJsonElement implements Serializable {
    private LocalDateTime start;
    private LocalDateTime end;
}
