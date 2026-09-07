package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SessionCountAnalyzerTest {

    SessionCountAnalyzer sessionCountAnalyzer = new SessionCountAnalyzer();

    @Test
    public void testCountSessions() {
        SleepAnalysisResult result = sessionCountAnalyzer.analyze(TestDataFactory.createSessions());
        assertEquals(3, result.getValue());
    }

    @Test
    public void testEmptySessions() {
        SleepAnalysisResult result = sessionCountAnalyzer.analyze(TestDataFactory.createEmptySessions());
        assertEquals(0, result.getValue());
    }
}
