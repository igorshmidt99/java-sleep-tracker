package ru.yandex.practicum.sleeptracker.function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.TestData;
import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.model.SleepStatus;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SleeplessDetectorFunctionTest {

    private TestData testData = new TestData();

    @Test
    @DisplayName("Функция должна вернуть одну бессноную ночь")
    void shouldReturnOneSleeplessNight() {
        SleeplessDetectorFunction sleeplessDetectorFunction = new SleeplessDetectorFunction();
        SleepAnalysisResult expected = new SleepAnalysisResult("Количество беcсоных ночей: ", 1);
        SleepAnalysisResult actual = sleeplessDetectorFunction.apply(testData.getSessions());

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Функция не должна вычислять значения при отсутствии записанных снов")
    void shouldReturnZeroSleeplessNightWhenListOfSessionsIsEmpty() {
        SleeplessDetectorFunction sleeplessDetectorFunction = new SleeplessDetectorFunction();
        SleepAnalysisResult actual = sleeplessDetectorFunction.apply(List.of());

        assertEquals(0, actual.getValue());
    }

    @Test
    @DisplayName("Функция не должна вычислять значения при отсутствии бессоных ночей")
    void shouldReturnZeroSleeplessNightWhenHasNoSleeplessNight() {
        SleeplessDetectorFunction sleeplessDetectorFunction = new SleeplessDetectorFunction();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        SleepAnalysisResult actual = sleeplessDetectorFunction.apply(List.of(new SleepingSession(
                        LocalDateTime.parse("01.10.25 22:15", formatter),
                        LocalDateTime.parse("02.10.25 08:00", formatter),
                        SleepStatus.GOOD),
                new SleepingSession(
                        LocalDateTime.parse("02.10.25 23:00", formatter),
                        LocalDateTime.parse("03.10.25 08:00", formatter),
                        SleepStatus.NORMAL)));
        SleepAnalysisResult expected = new SleepAnalysisResult("Количество беcсоных ночей: ", 0);

        assertEquals(expected, actual);
    }


    @Test
    @DisplayName("Функция должна обнаружить две бесснонные ночи")
    void shouldReturnTwoSleeplessNights() {
        SleeplessDetectorFunction sleeplessDetectorFunction = new SleeplessDetectorFunction();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        SleepAnalysisResult actual = sleeplessDetectorFunction.apply(List.of(
                new SleepingSession(
                        LocalDateTime.parse("02.10.25 06:00", formatter),
                        LocalDateTime.parse("02.10.25 08:00", formatter),
                        SleepStatus.NORMAL),
                new SleepingSession(
                        LocalDateTime.parse("03.10.25 22:00", formatter),
                        LocalDateTime.parse("04.10.25 00:00", formatter),
                        SleepStatus.NORMAL))
        );
        SleepAnalysisResult expected = new SleepAnalysisResult("Количество беcсоных ночей: ", 2);

        assertEquals(expected, actual);
    }


}