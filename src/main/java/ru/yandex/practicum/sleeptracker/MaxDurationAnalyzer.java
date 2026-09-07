package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

public class MaxDurationAnalyzer implements SleepAnalyzer {
    @Override
    public SleepAnalysisResult analyze(List<SleepSession> sessions) {
        long max = sessions.stream()
                .map(x -> Duration.between(x.start, x.end).toMinutes())
                .max(Comparator.comparing(x -> x))
                .orElse(0L);
        return new SleepAnalysisResult("Максимальная продолжительность ", max);
    }
}
