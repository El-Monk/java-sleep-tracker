package ru.yandex.practicum.sleeptracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ChronotypeAnalyzer implements SleepAnalyzer {
    @Override
    public SleepAnalysisResult analyze(List<SleepSession> sessions) {
        LocalDate firstNight;
        if (sessions.getFirst().start.getHour() > 12) {
            firstNight = sessions.getFirst().start.toLocalDate().plusDays(1);
        } else {

            firstNight = sessions.getFirst().start.toLocalDate();
        }

        LocalDate lastNight = sessions.getLast().end.toLocalDate();

        long coustNights = ChronoUnit.DAYS.between(firstNight, lastNight) + 1;

        List<LocalDate> nights = LongStream.range(0, coustNights)
                .mapToObj(i -> firstNight.plusDays(i))
                .toList();

        Map<String, Long> larkChronotype = nights.stream()
                .map(night -> sessions.stream()
                        .filter(session ->
                                session.start.isBefore(night.atTime(6, 0)) &&
                                        session.end.isAfter(night.atStartOfDay()))
                        .findFirst())
                .map(optional ->
                        optional.map(session -> determineChronotype(session.start.toLocalTime(), session.end.toLocalTime())))
                .filter(optional -> optional.isPresent())
                .map(Optional::get)
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        long max = larkChronotype.values()
                .stream().max(Long::compareTo)
                .orElse(0L);

        long leadersCount = larkChronotype.entrySet().stream()
                .filter(x -> x.getValue() == max)
                .count();

        String resultChronotype;

        if (leadersCount == 1) {
            resultChronotype = larkChronotype.entrySet().stream()
                    .filter(x -> x.getValue() == max)
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse("Голубь");
        } else {
            resultChronotype = "Голубь";
        }


        return new SleepAnalysisResult("Хронотип режима сна - ", resultChronotype);
    }

    public String determineChronotype(LocalTime start, LocalTime end) {
        LocalTime ownStartSleppAfter = LocalTime.of(23, 0);
        LocalTime ownEndSleepAfter = LocalTime.of(9, 0);
        LocalTime larkStartSleepBefore = LocalTime.of(22, 0);
        LocalTime larkEndSleepBefore = LocalTime.of(7, 0);

        if (start.isAfter(ownStartSleppAfter) && end.isAfter(ownEndSleepAfter)) {
            return "Сова";
        } else if (start.isBefore(larkStartSleepBefore) &&
                end.isBefore(larkEndSleepBefore)) {
            return "Жаворонок";
        } else {
            return "Голубь";
        }
    }
}
