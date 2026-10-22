package ru.yandex.practicum.sleeptracker.function;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.TestData;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SessionsAmountFunctionTest {

    private TestData testData = new TestData();

    @Test
    void sessionAmountFunctionReturnsNonZeroValue() {
        SessionsAmountFunction sessionsAmountFunction = new SessionsAmountFunction();
        SleepAnalysisResult apply = sessionsAmountFunction.apply(testData.getSessions());

        assertNotEquals(0, apply.getValue());
    }

    @Test
    void sessionAmountFunctionReturnsZero() {
        SessionsAmountFunction sessionsAmountFunction = new SessionsAmountFunction();
        SleepAnalysisResult apply = sessionsAmountFunction.apply(List.of());

        assertEquals(0, apply.getValue());
    }

}