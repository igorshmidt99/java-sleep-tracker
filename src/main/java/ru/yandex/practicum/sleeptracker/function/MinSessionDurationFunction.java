package ru.yandex.practicum.sleeptracker.function;

import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MinSessionDurationFunction implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        SleepingSession min = sleepingSessions.stream()
                .min(Comparator.naturalOrder())
                .get();
        long duration = Duration.between(min.getStartTime(), min.getEndTime()).toMinutes();
        return new SleepAnalysisResult("Минимальная продолжительность сессии: ", duration);
    }

}
