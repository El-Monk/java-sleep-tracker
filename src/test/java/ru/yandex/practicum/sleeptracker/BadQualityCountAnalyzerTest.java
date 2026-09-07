package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadQualityCountAnalyzerTest {

    BadQualityCountAnalyzer badQualityCountAnalyzer = new BadQualityCountAnalyzer();

    @Test
    public void testBadQualityCount() {
        SleepAnalysisResult result = badQualityCountAnalyzer.analyze(TestDataFactory.createSessions());
        assertEquals(1L, result.getValue());
    }

    @Test
    public void testEmptyListBadQualityCount() {
        SleepAnalysisResult result = badQualityCountAnalyzer.analyze(TestDataFactory.createEmptySessions());
        assertEquals(0L, result.getValue());
    }
}
