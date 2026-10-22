package ru.yandex.practicum.sleeptracker.function;

import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.util.List;
import java.util.function.Function;

public class FunctionFactory {

    public static List<Function<List<SleepingSession>, SleepAnalysisResult>> getFunctions() {
        return List.of(
                new SessionsAmountFunction(),
                new MinSessionDurationFunction(),
                new MaxSessionDurationFunction(),
                new AverageSessionDurationFunction(),
                new SessionAmountBadQualityFunction(),
                new SleeplessDetectorFunction(),
                new UserClassificationFunction()
        );
    }

}
