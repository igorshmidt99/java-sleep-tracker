package ru.yandex.practicum.sleeptracker.function;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;
import ru.yandex.practicum.sleeptracker.TestData;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AverageSessionDurationFunctionTest {

    private TestData testData = new TestData();

    @Test
    void averageDurationFunctionWithSeveralSessionsShouldReturnAverageDuration() {
        List<SleepingSession> sessions = testData.getSessions();
        AverageSessionDurationFunction averageSessionDurationFunction = new AverageSessionDurationFunction();
        SleepAnalysisResult actual = averageSessionDurationFunction.apply(sessions);
        SleepAnalysisResult expected = new SleepAnalysisResult("Средняя продолжительность сна в минутах: ", 396L);

        assertEquals(expected, actual);
    }

    @Test
    void averageDurationFunctionWithEmptySessionsShouldReturnZero() {
        List<SleepingSession> sessions = List.of();
        AverageSessionDurationFunction averageSessionDurationFunction = new AverageSessionDurationFunction();
        SleepAnalysisResult actual = averageSessionDurationFunction.apply(sessions);
        SleepAnalysisResult expected = new SleepAnalysisResult("Средняя продолжительность сна в минутах: ", 0L);

        assertEquals(expected, actual);
    }

}
