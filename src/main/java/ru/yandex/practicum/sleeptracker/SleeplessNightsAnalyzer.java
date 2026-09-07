package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class SleeplessNightsAnalyzer implements SleepAnalyzer {
    @Override
    public SleepAnalysisResult analyze (List<SleepSession> sessions) {
        if (sessions.size() == 0 ) {
            return new SleepAnalysisResult("Количество бессоных ночей ", 0L);
        }

        LocalDate firstNight;
        if (sessions.getFirst().start.getHour() > 12) {
            firstNight = sessions.getFirst().start.toLocalDate().plusDays(1);
        } else {
            firstNight = sessions.getFirst().start.toLocalDate();
        }

        LocalDate lastNight = sessions.getLast().end.toLocalDate();

        long coustNight = ChronoUnit.DAYS.between(firstNight, lastNight) + 1;

        List<LocalDate> nights = LongStream.range(0, coustNight)
                .mapToObj(i -> firstNight.plusDays(i))
                .toList();

        long noSleepNights = nights.stream()
                .filter(night -> sessions.stream().noneMatch(session ->
                        session.start.isBefore(night.atTime(6,0)) &&
                        session.end.isAfter(night.atStartOfDay())))
                .count();

        return new SleepAnalysisResult("Количество бессоных ночей ", noSleepNights);
    }
}
