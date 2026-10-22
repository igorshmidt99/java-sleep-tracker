package ru.yandex.practicum.sleeptracker.function;

import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.model.SleepStatus;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.util.List;
import java.util.function.Function;

public class SessionAmountBadQualityFunction implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        List<SleepingSession> badSessions = sleepingSessions.stream()
                .filter(session -> session.getStatus().equals(SleepStatus.BAD))
                .toList();
        return new SleepAnalysisResult("Количество сессий с плохим качеством сна: ", badSessions.size());
    }
}
