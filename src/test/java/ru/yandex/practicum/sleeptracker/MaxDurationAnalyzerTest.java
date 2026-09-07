package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxDurationAnalyzerTest {

    MaxDurationAnalyzer maxDurationAnalyzer = new MaxDurationAnalyzer();

    @Test
    public void testMaxDuration() {
        SleepAnalysisResult result = maxDurationAnalyzer.analyze(TestDataFactory.createSessions());
        assertEquals(570L, result.getValue());
    }

    @Test
    public void testEmptyListMaxDuration() {
        SleepAnalysisResult result = maxDurationAnalyzer.analyze(TestDataFactory.createEmptySessions());
        assertEquals(0L, result.getValue());
    }
}
