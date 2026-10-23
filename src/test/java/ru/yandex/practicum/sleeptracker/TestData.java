package ru.yandex.practicum.sleeptracker;

import ru.yandex.practicum.sleeptracker.model.SleepStatus;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TestData {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");

    private List<SleepingSession> sessions = List.of(
            new SleepingSession(
                    LocalDateTime.parse("01.10.25 22:15", formatter),
                    LocalDateTime.parse("02.10.25 08:00", formatter),
                    SleepStatus.GOOD
            ),
            new SleepingSession(
                    LocalDateTime.parse("02.10.25 23:00", formatter),
                    LocalDateTime.parse("03.10.25 08:00", formatter),
                    SleepStatus.NORMAL
            ),
            new SleepingSession(
                    LocalDateTime.parse("03.10.25 14:30", formatter),
                    LocalDateTime.parse("03.10.25 15:20", formatter),
                    SleepStatus.NORMAL
            ),
            new SleepingSession(
                    LocalDateTime.parse("03.10.25 23:30", formatter),
                    LocalDateTime.parse("04.10.25 06:20", formatter),
                    SleepStatus.BAD
            )
    );

    public List<SleepingSession> getSessions() {
        return sessions;
    }
}
