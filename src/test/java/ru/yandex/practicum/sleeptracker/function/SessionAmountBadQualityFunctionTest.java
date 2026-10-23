package ru.yandex.practicum.sleeptracker.function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.TestData;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SessionAmountBadQualityFunctionTest {

    private TestData testData = new TestData();

    @Test
    @DisplayName("Тест показывает работу функции при множестве сессий плохого качества")
    void functionShouldReturnAllBadSessionsSize() {
        SessionAmountBadQualityFunction sessionAmountBadQualityFunction = new SessionAmountBadQualityFunction();
        SleepAnalysisResult actual = sessionAmountBadQualityFunction.apply(testData.getSessions());
        SleepAnalysisResult expected = new SleepAnalysisResult("Количество сессий с плохим качеством сна: ", 1);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Тест показывает работу функции при отсутствии сессий плохого качества")
    void functionShouldNotReturnBadSessions() {
        SessionAmountBadQualityFunction sessionAmountBadQualityFunction = new SessionAmountBadQualityFunction();
        SleepAnalysisResult actual = sessionAmountBadQualityFunction.apply(List.of());
        SleepAnalysisResult expected = new SleepAnalysisResult("Количество сессий с плохим качеством сна: ", 0);

        assertEquals(expected, actual);
    }

}