package ch.ttt.memogram.domain.appointment;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Appointment {
    private final String title;
    private final LocalDateTime start;
    private final LocalDateTime end;
}
