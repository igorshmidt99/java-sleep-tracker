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

class MinSessionDurationFunctionTest {

    private TestData testData = new TestData();

    @Test
    @DisplayName("Функция должна вычислить минимальную продолжительность сна среди всех сессий")
    void minSessionFunctionShouldWithSomeSessionReturnMinSession() {
        List<SleepingSession> sessions = testData.getSessions();
        MinSessionDurationFunction minSessionDurationFunction = new MinSessionDurationFunction();
        SleepAnalysisResult actual = minSessionDurationFunction.apply(sessions);
        SleepAnalysisResult expected = new SleepAnalysisResult("Минимальная продолжительность сессии: ", 50L);

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Функция должна вычислить минимальную продолжительность сна среди одной сессии")
    void minSessionFunctionWithOneSessionShouldReturnMinSession() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        List<SleepingSession> sessions = List.of(new SleepingSession(
                LocalDateTime.parse("01.10.25 22:15", formatter),
                LocalDateTime.parse("02.10.25 08:00", formatter),
                SleepStatus.GOOD
        ));
        MinSessionDurationFunction minSessionDurationFunction = new MinSessionDurationFunction();
        SleepAnalysisResult actual = minSessionDurationFunction.apply(sessions);
        SleepAnalysisResult expected = new SleepAnalysisResult("Минимальная продолжительность сессии: ", 585L);

        assertEquals(expected, actual);

    }


    @Test
    @DisplayName("Функция выбрасывает исключение когда сессии сна отсутствуют")
    void minSessionFunctionWithNoSessionShouldThrowNoSuchElementException() {
        List<SleepingSession> sessions = List.of();
        MinSessionDurationFunction minSessionDurationFunction = new MinSessionDurationFunction();

        assertThrows(NoSuchElementException.class, () -> minSessionDurationFunction.apply(sessions));

    }


}