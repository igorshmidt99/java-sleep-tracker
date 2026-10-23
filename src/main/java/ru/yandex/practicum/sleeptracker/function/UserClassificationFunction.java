package ru.yandex.practicum.sleeptracker.function;

import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;
import ru.yandex.practicum.sleeptracker.model.UserClassification;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserClassificationFunction implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        UserClassification classification = sleepingSessions.stream()
                .map(this::classify)
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
        return new SleepAnalysisResult("Пользователь: ", classification.toString());
    }

    private UserClassification classify(SleepingSession session) {
        LocalDateTime start = session.getStartTime();
        LocalDateTime end = session.getEndTime();

        if (!start.toLocalDate().isBefore(end.toLocalDate())
                || !start.isBefore(end)) {
            return null;
        }

        LocalTime bedtime = start.toLocalTime();
        LocalTime wakeup = end.toLocalTime();

        if (bedtime.isAfter(LocalTime.of(23, 0))
                && wakeup.isAfter(LocalTime.of(9, 0))) {
            return UserClassification.СОВА;
        }

        if (bedtime.isBefore(LocalTime.of(22, 0))
                && wakeup.isBefore(LocalTime.of(7, 0))) {
            return UserClassification.ЖАВОРОНОК;
        }

        return UserClassification.ГОЛУБЬ;
    }
}
