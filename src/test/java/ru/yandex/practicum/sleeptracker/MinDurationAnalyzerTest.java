package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinDurationAnalyzerTest {

    MinDurationAnalyzer minDurationAnalyzer = new MinDurationAnalyzer();

    @Test
    public void testMinDuration() {
        SleepAnalysisResult result = minDurationAnalyzer.analyze(TestDataFactory.createSessions());
        assertEquals(420L, result.getValue());
    }

    @Test
    public void testEmptyListMinDuration() {
        SleepAnalysisResult result = minDurationAnalyzer.analyze(TestDataFactory.createEmptySessions());
        assertEquals(0L, result.getValue());
    }
}
