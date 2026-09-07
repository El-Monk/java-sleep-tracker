package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SleeplessNightsAnalyzerTest {
     SleeplessNightsAnalyzer sleeplessNightsAnalyzer =new SleeplessNightsAnalyzer();

     @Test
     public void allSessionsOnDayTest() {
         SleepAnalysisResult result = sleeplessNightsAnalyzer.analyze(TestDataFactory.createAllSessionsOnDay());
         assertEquals(2L, result.getValue());
     }

     @Test
    public void emptySessionsTest() {
         SleepAnalysisResult result = sleeplessNightsAnalyzer.analyze(TestDataFactory.createEmptySessions());
         assertEquals(0L, result.getValue());
     }

     @Test
     public void allSessionsNotSleeplessTest() {
         SleepAnalysisResult result = sleeplessNightsAnalyzer.analyze(TestDataFactory.createAllSessionsNotSleepless());
         assertEquals(0L, result.getValue());
     }

     @Test
    public void firstSessionsAfterNoonTest() {
         SleepAnalysisResult result = sleeplessNightsAnalyzer.analyze(TestDataFactory.createFirstSessionAfterNoon());
         assertEquals(2L, result.getValue());
     }
}
