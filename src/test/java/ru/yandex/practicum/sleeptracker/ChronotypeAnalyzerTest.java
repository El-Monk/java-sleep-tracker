package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChronotypeAnalyzerTest {
    ChronotypeAnalyzer chronotypeAnalyzer = new ChronotypeAnalyzer();

    @Test
    public void testChronotypeOnw() {
        SleepAnalysisResult result = chronotypeAnalyzer.analyze(TestDataFactory.createOwnSessions());
        assertEquals("Сова", result.getValue());
    }

    @Test
    public void testChronotypeLark() {
        SleepAnalysisResult result = chronotypeAnalyzer.analyze(TestDataFactory.createLarkSessions());
        assertEquals("Жаворонок", result.getValue());
    }

    @Test
    public void testEqualsChronotype() {
        SleepAnalysisResult result = chronotypeAnalyzer.analyze(TestDataFactory.createEqualChronotypeSessions());
        assertEquals("Голубь", result.getValue());
    }
}
