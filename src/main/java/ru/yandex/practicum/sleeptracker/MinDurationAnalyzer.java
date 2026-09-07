package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

public class MinDurationAnalyzer implements SleepAnalyzer {
    @Override
    public SleepAnalysisResult analyze(List<SleepSession> sessions) {
        long min = sessions.stream()
                .map(x -> Duration.between(x.start, x.end).toMinutes())
                .min(Comparator.comparing(x -> x))
                .orElse(0L);
        return new SleepAnalysisResult("Минимальная продолжительность - ", min);
    }
}
