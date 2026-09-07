package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;

public class AverageDurationAnalyzer implements SleepAnalyzer {
    @Override
    public SleepAnalysisResult analyze (List<SleepSession> sessions) {
        double average = sessions.stream()
                .map(x -> Duration.between(x.start, x.end).toMinutes())
                .mapToDouble(x -> x)
                .average()
                .orElse(0.0);
        return new SleepAnalysisResult("Средняя продолжительность ", average);
    }
}
