package ru.yandex.practicum.sleeptracker.util;

import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.time.LocalDateTime;

public class SleeplessDetector {

        private static final int SLEEP_BOUNDARY_END_HOUR = 6;
        private static final int DAYS_TO_NEXT_MIDNIGHT = 1;

    public static boolean intersectionWithSleepBoundaries(SleepingSession session) {
            LocalDateTime start = session.getStartTime();
            LocalDateTime end = session.getEndTime();

            LocalDateTime midnight = start.toLocalDate().atStartOfDay();
            LocalDateTime sixAM = midnight.plusHours(SLEEP_BOUNDARY_END_HOUR);

            boolean intersectsStartDate =
                    start.isBefore(sixAM) && end.isAfter(midnight);

            LocalDateTime nextMidnight = midnight.plusDays(DAYS_TO_NEXT_MIDNIGHT);
            LocalDateTime nextSixAM = nextMidnight.plusHours(SLEEP_BOUNDARY_END_HOUR);

            boolean intersectsNextDate =
                    start.isBefore(nextSixAM) && end.isAfter(nextMidnight);

            return !(intersectsStartDate || intersectsNextDate);
    }

}
