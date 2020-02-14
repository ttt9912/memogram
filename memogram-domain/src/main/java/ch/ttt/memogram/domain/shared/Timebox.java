package ch.ttt.memogram.domain.shared;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Timebox {
    private LocalDateTime start;
    private LocalDateTime end;
}
