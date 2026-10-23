package ru.yandex.practicum.sleeptracker.function;

import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class AverageSessionDurationFunction implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        SleepAnalysisResult sleepAnalysisResult = new SleepAnalysisResult("Средняя продолжительность сна в минутах: ", 0L);
        try {
            long averageSession = sleepingSessions.stream()
                    .map(session -> Duration.between(session.getStartTime(), session.getEndTime()))
                    .reduce(Duration.ZERO, Duration::plus)
                    .dividedBy(sleepingSessions.size())
                    .toMinutes();
            sleepAnalysisResult.setValue(averageSession);
        } catch (ArithmeticException e) {
            return sleepAnalysisResult;
        }
        return sleepAnalysisResult;
    }
}
