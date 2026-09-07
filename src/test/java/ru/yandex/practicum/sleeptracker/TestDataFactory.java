package ru.yandex.practicum.sleeptracker;

import java.time.LocalDateTime;
import java.util.List;

public class TestDataFactory {
    public static List<SleepSession> createSessions() {
        return List.of(
                new SleepSession(
                        LocalDateTime.of(2025, 10, 1, 22, 0),
                        LocalDateTime.of(2025, 10, 2, 7, 30),
                        SleepQuality.GOOD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 2, 23, 0),
                        LocalDateTime.of(2025, 10, 3, 6, 0),
                        SleepQuality.NORMAL
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 3, 23, 40),
                        LocalDateTime.of(2025, 10, 4, 8, 0),
                        SleepQuality.BAD
                )
        );
    }

    public static List<SleepSession> createOwnSessions() {
        return List.of(
                new SleepSession(
                        LocalDateTime.of(2025, 10, 1, 22, 0),
                        LocalDateTime.of(2025, 10, 2, 7, 30),
                        SleepQuality.GOOD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 4, 23, 15),
                        LocalDateTime.of(2025, 10, 5, 9, 30),
                        SleepQuality.GOOD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 7, 23, 30),
                        LocalDateTime.of(2025, 10, 8, 9, 5),
                        SleepQuality.NORMAL
                )
        );
    }

    public static List<SleepSession> createLarkSessions() {
        return List.of(
                new SleepSession(
                        LocalDateTime.of(2025, 10, 1, 22, 0),
                        LocalDateTime.of(2025, 10, 2, 7, 30),
                        SleepQuality.GOOD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 2, 21, 15),
                        LocalDateTime.of(2025, 10, 3, 6, 30),
                        SleepQuality.GOOD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 3, 21, 30),
                        LocalDateTime.of(2025, 10, 4, 6, 5),
                        SleepQuality.NORMAL
                )
        );
    }

    public static List<SleepSession> createEqualChronotypeSessions() {
        return List.of(
                new SleepSession(
                        LocalDateTime.of(2025, 10, 3, 21, 15),
                        LocalDateTime.of(2025, 10, 4, 6, 30),
                        SleepQuality.GOOD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 4, 21, 30),
                        LocalDateTime.of(2025, 10, 5, 6, 5),
                        SleepQuality.NORMAL
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 5, 23, 15),
                        LocalDateTime.of(2025, 10, 6, 9, 30),
                        SleepQuality.GOOD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 6, 23, 30),
                        LocalDateTime.of(2025, 10, 7, 9, 5),
                        SleepQuality.NORMAL
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 7, 17, 0),
                        LocalDateTime.of(2025, 10, 8, 21, 0),
                        SleepQuality.BAD
                )
        );
    }

    public static List<SleepSession> createAllSessionsOnDay() {
        return List.of(
                new SleepSession(
                        LocalDateTime.of(2025, 10, 7, 6, 30),
                        LocalDateTime.of(2025, 10, 7, 11, 50),
                        SleepQuality.BAD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 8, 17, 0),
                        LocalDateTime.of(2025, 10, 8, 23, 0),
                        SleepQuality.BAD
                )
        );
    }

    public static List<SleepSession> createAllSessionsNotSleepless() {
        return List.of(
                new SleepSession(
                        LocalDateTime.of(2025, 10, 1, 22, 0),
                        LocalDateTime.of(2025, 10, 2, 7, 30),
                        SleepQuality.GOOD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 2, 19, 0),
                        LocalDateTime.of(2025, 10, 3, 5, 0),
                        SleepQuality.GOOD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 4, 1, 0),
                        LocalDateTime.of(2025, 10, 4, 10, 30),
                        SleepQuality.GOOD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 5, 2, 0),
                        LocalDateTime.of(2025, 10, 5, 5, 30),
                        SleepQuality.GOOD
                )
        );
    }

    public static List<SleepSession> createFirstSessionAfterNoon() {
        return List.of(
                new SleepSession(
                        LocalDateTime.of(2025, 10, 1, 13, 0),
                        LocalDateTime.of(2025, 10, 1, 17, 0),
                        SleepQuality.BAD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 2, 13, 0),
                        LocalDateTime.of(2025, 10, 2, 17, 0),
                        SleepQuality.BAD
                ),
                new SleepSession(
                        LocalDateTime.of(2025, 10, 3, 23, 0),
                        LocalDateTime.of(2025, 10, 4, 7, 0),
                        SleepQuality.GOOD
                )
        );
    }

    public static List<SleepSession> createEmptySessions() {
        return List.of();
    }
}
