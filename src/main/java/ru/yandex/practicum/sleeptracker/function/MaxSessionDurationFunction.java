package ru.yandex.practicum.sleeptracker.function;

import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MaxSessionDurationFunction implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        SleepingSession max = sleepingSessions.stream()
                .max(Comparator.naturalOrder())
                .get();
        long duration = Duration.between(max.getStartTime(), max.getEndTime()).toMinutes();
        return new SleepAnalysisResult("Максимальная продолжительность сессии: ", duration);

    }

}
