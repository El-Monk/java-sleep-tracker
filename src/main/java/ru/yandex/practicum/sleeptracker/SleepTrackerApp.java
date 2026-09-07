package ru.yandex.practicum.sleeptracker;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SleepTrackerApp {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(args[0])))) {
//                new FileInputStream("src/main/resources/sleep_log.txt")))) {
            List<SleepSession> sleepSessions = reader.lines()
                    .map(line -> line.split(";"))
                    .map(parts -> new SleepSession(
                            LocalDateTime.parse(parts[0], formatter),
                            LocalDateTime.parse(parts[1], formatter),
                            SleepQuality.valueOf(parts[2])
                    ))
                    .toList();

            List<SleepAnalyzer> resultSessions = new ArrayList<>();
            resultSessions.add(new SessionCountAnalyzer());
            resultSessions.add(new MinDurationAnalyzer());
            resultSessions.add(new MaxDurationAnalyzer());
            resultSessions.add(new AverageDurationAnalyzer());
            resultSessions.add(new BadQualityCountAnalyzer());
            resultSessions.add(new SleeplessNightsAnalyzer());
            resultSessions.add(new ChronotypeAnalyzer());

            resultSessions.forEach(t -> {
                SleepAnalysisResult session = t.analyze(sleepSessions);

                if (session.value instanceof Double) {
                    String formatted = String.format("%.1f", session.value);
                    System.out.println(session.description + formatted);
                } else {
                    System.out.println(session.description + session.value);
                }
            });


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}