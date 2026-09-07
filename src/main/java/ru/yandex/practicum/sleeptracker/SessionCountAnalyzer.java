package ru.yandex.practicum.sleeptracker;

import java.util.List;

public class SessionCountAnalyzer implements SleepAnalyzer {
    @Override
    public SleepAnalysisResult analyze(List<SleepSession> sessions) {
        return new SleepAnalysisResult("Всего сессий ", sessions.size());
    }
}
