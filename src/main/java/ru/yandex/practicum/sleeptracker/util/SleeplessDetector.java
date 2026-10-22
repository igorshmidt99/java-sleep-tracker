package ru.yandex.practicum.sleeptracker.util;

import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.time.LocalDateTime;

public class SleeplessDetector {

    public static boolean intersectionWithSleepBoundaries(SleepingSession session) {
            LocalDateTime start = session.getStartTime();
            LocalDateTime end = session.getEndTime();

            LocalDateTime midnight = start.toLocalDate().atStartOfDay();
            LocalDateTime sixAM = midnight.plusHours(6);

            boolean intersectsStartDate =
                    start.isBefore(sixAM) && end.isAfter(midnight);

            LocalDateTime nextMidnight = midnight.plusDays(1);
            LocalDateTime nextSixAM = nextMidnight.plusHours(6);

            boolean intersectsNextDate =
                    start.isBefore(nextSixAM) && end.isAfter(nextMidnight);

            return !(intersectsStartDate || intersectsNextDate);
    }

}
