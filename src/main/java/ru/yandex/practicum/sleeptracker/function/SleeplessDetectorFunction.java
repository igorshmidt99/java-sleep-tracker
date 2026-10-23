package ru.yandex.practicum.sleeptracker.function;

import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;
import ru.yandex.practicum.sleeptracker.util.SleeplessDetector;

import java.util.List;
import java.util.function.Function;

public class SleeplessDetectorFunction implements Function<List<SleepingSession>, SleepAnalysisResult> {

    @Override
    public SleepAnalysisResult apply(List<SleepingSession> sleepingSessions) {
        List<SleepingSession> sleeplessSessions = sleepingSessions.stream()
                .filter(SleeplessDetector::intersectionWithSleepBoundaries)
                .toList();
        return new SleepAnalysisResult("Количество беcсоных ночей: ", sleeplessSessions.size());
    }

}
