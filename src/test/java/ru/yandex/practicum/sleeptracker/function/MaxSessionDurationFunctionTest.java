package ru.yandex.practicum.sleeptracker.function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.model.SleepStatus;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;
import ru.yandex.practicum.sleeptracker.TestData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MaxSessionDurationFunctionTest {

    private TestData testData = new TestData();

    @Test
    @DisplayName("Функция должна вычислить максимальную продолжительность сна среди всех сессий")
    void maxSessionFunctionShouldWithSomeSessionReturnMaxSession() {
        List<SleepingSession> sessions = testData.getSessions();
        MaxSessionDurationFunction maxSessionDurationFunction = new MaxSessionDurationFunction();
        SleepAnalysisResult actual = maxSessionDurationFunction.apply(sessions);
        SleepAnalysisResult expected = new SleepAnalysisResult("Максимальная продолжительность сессии: ", 585L);

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Функция должна вычислить максимальную продолжительность сна среди одной сессии")
    void maxSessionFunctionWithOneSessionShouldReturnMaxSession() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        List<SleepingSession> sessions = List.of(new SleepingSession(
                LocalDateTime.parse("01.10.25 22:15", formatter),
                LocalDateTime.parse("02.10.25 08:00", formatter),
                SleepStatus.GOOD
        ));
        MaxSessionDurationFunction maxSessionDurationFunction = new MaxSessionDurationFunction();
        SleepAnalysisResult actual = maxSessionDurationFunction.apply(sessions);
        SleepAnalysisResult expected = new SleepAnalysisResult("Максимальная продолжительность сессии: ", 585L);

        assertEquals(expected, actual);

    }


    @Test
    @DisplayName("Функция выбрасывает исключение когда сессии сна отсутствуют")
    void maxSessionFunctionWithNoSessionShouldThrowNoSuchElementException() {
        List<SleepingSession> sessions = List.of();
        MinSessionDurationFunction minSessionDurationFunction = new MinSessionDurationFunction();

        assertThrows(NoSuchElementException.class, () -> minSessionDurationFunction.apply(sessions));

    }


}