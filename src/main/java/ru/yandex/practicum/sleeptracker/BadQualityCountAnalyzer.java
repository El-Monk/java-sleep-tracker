package ru.yandex.practicum.sleeptracker;

import java.time.Duration;
import java.util.List;

public class BadQualityCountAnalyzer implements SleepAnalyzer {
    @Override
    public SleepAnalysisResult analyze(List<SleepSession> sessions) {
        long count = sessions.stream()
                .filter(x -> x.quality == SleepQuality.BAD)
                .count();
        return new SleepAnalysisResult("количество сессий с плохим качеством сна ", count);
    }
}
