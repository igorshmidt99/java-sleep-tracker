package ru.yandex.practicum.sleeptracker.function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.TestData;
import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.model.SleepStatus;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;
import ru.yandex.practicum.sleeptracker.model.UserClassification;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserClassificationFunctionTest {

    private TestData testData = new TestData();

    @Test
    @DisplayName("На стандартных тестовых данных пользователь является голубем")
    void functionShouldReturnGolub() {
        UserClassificationFunction userClassificationFunction = new UserClassificationFunction();
        SleepAnalysisResult actual = userClassificationFunction.apply(testData.getSessions());

        assertEquals(UserClassification.ГОЛУБЬ.toString(), actual.getValue());
    }

    @Test
    @DisplayName("Пользователь является совой")
    void functionShouldReturnSova() {
        UserClassificationFunction userClassificationFunction = new UserClassificationFunction();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        SleepAnalysisResult actual = userClassificationFunction.apply(List.of(
                new SleepingSession(
                        LocalDateTime.parse("01.10.25 23:30", formatter),
                        LocalDateTime.parse("02.10.25 10:00", formatter),
                        SleepStatus.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.parse("02.10.25 23:45", formatter),
                        LocalDateTime.parse("03.10.25 09:30", formatter),
                        SleepStatus.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.parse("03.10.25 23:15", formatter),
                        LocalDateTime.parse("04.10.25 11:00", formatter),
                        SleepStatus.NORMAL
                ),
                new SleepingSession(
                        LocalDateTime.parse("04.10.25 23:59", formatter),
                        LocalDateTime.parse("05.10.25 10:30", formatter),
                        SleepStatus.GOOD
                )
        ));

        assertEquals(UserClassification.СОВА.toString(), actual.getValue());
    }

    @Test
    @DisplayName("Пользователь является голубем")
    void functionShouldReturnGolubWithMixedData() {
        UserClassificationFunction userClassificationFunction = new UserClassificationFunction();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        SleepAnalysisResult actual = userClassificationFunction.apply(List.of(
                new SleepingSession(
                        LocalDateTime.parse("01.10.25 23:30", formatter),
                        LocalDateTime.parse("02.10.25 10:00", formatter),
                        SleepStatus.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.parse("02.10.25 23:45", formatter),
                        LocalDateTime.parse("03.10.25 09:30", formatter),
                        SleepStatus.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.parse("03.10.25 23:15", formatter),
                        LocalDateTime.parse("04.10.25 11:00", formatter),
                        SleepStatus.NORMAL
                ),
                new SleepingSession(
                        LocalDateTime.parse("04.10.25 21:00", formatter),
                        LocalDateTime.parse("05.10.25 06:00", formatter),
                        SleepStatus.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.parse("05.10.25 21:30", formatter),
                        LocalDateTime.parse("06.10.25 06:30", formatter),
                        SleepStatus.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.parse("06.10.25 20:45", formatter),
                        LocalDateTime.parse("07.10.25 05:45", formatter),
                        SleepStatus.NORMAL
                ),
                new SleepingSession(
                        LocalDateTime.parse("07.10.25 22:30", formatter),
                        LocalDateTime.parse("08.10.25 07:30", formatter),
                        SleepStatus.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.parse("08.10.25 22:00", formatter),
                        LocalDateTime.parse("09.10.25 08:00", formatter),
                        SleepStatus.NORMAL
                ),
                new SleepingSession(
                        LocalDateTime.parse("09.10.25 23:00", formatter),
                        LocalDateTime.parse("10.10.25 08:30", formatter),
                        SleepStatus.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.parse("10.10.25 21:45", formatter),
                        LocalDateTime.parse("11.10.25 07:30", formatter),
                        SleepStatus.NORMAL
                ),
                new SleepingSession(
                        LocalDateTime.parse("11.10.25 22:30", formatter),
                        LocalDateTime.parse("12.10.25 06:30", formatter),
                        SleepStatus.BAD
                ),
                new SleepingSession(
                        LocalDateTime.parse("12.10.25 22:15", formatter),
                        LocalDateTime.parse("13.10.25 08:30", formatter),
                        SleepStatus.GOOD
                ))
        );

        assertEquals(UserClassification.ГОЛУБЬ.toString(), actual.getValue());
    }


    @Test
    @DisplayName("Пользователь является жаворонком")
    void functionShouldReturnJavoronok() {
        UserClassificationFunction userClassificationFunction = new UserClassificationFunction();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        SleepAnalysisResult actual = userClassificationFunction.apply(List.of(
                new SleepingSession(
                        LocalDateTime.parse("01.10.25 21:00", formatter),
                        LocalDateTime.parse("02.10.25 06:00", formatter),
                        SleepStatus.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.parse("02.10.25 21:30", formatter),
                        LocalDateTime.parse("03.10.25 06:30", formatter),
                        SleepStatus.GOOD
                ),
                new SleepingSession(
                        LocalDateTime.parse("03.10.25 20:45", formatter),
                        LocalDateTime.parse("04.10.25 05:45", formatter),
                        SleepStatus.NORMAL
                ),
                new SleepingSession(
                        LocalDateTime.parse("04.10.25 21:15", formatter),
                        LocalDateTime.parse("05.10.25 06:45", formatter),
                        SleepStatus.GOOD
                ))
        );

        assertEquals(UserClassification.ЖАВОРОНОК.toString(), actual.getValue());
    }

}