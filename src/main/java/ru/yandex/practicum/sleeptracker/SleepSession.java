package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;

public class SleepSession {
    LocalDateTime start;
    LocalDateTime end;
    SleepQuality quality;

    public SleepSession(LocalDateTime start, LocalDateTime end, SleepQuality quality) {
        this.start = start;
        this.end = end;
        this.quality = quality;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public SleepQuality getQuality() {
        return quality;
    }
}
