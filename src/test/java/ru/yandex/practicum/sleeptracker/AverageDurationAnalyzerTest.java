package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AverageDurationAnalyzerTest {

    AverageDurationAnalyzer averageDurationAnalyzer = new AverageDurationAnalyzer();

    @Test
    public void testAverage() {
        SleepAnalysisResult result = averageDurationAnalyzer.analyze(TestDataFactory.createSessions());
        assertEquals(496.6667, (double) result.getValue(), 0.0001);
    }

    @Test
    public void testEmptyListAverage() {
        SleepAnalysisResult result = averageDurationAnalyzer.analyze(TestDataFactory.createEmptySessions());
        assertEquals(0.0, result.getValue());
    }
}
