package ru.yandex.practicum.sleeptracker;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SleepingLogParserTest {

    private final SleepingLogParser parser = new SleepingLogParser();

    @Test
    void shouldParseLogFile() {
        List<SleepingSession> sessions = parser.parse("src/main/resources/sleep_log.txt");
        assertNotEquals(0, sessions.size());
    }

    @Test
    void whenLogFileNotFoundShouldThrowException() {
        assertThrows(RuntimeException.class, () -> parser.parse(""));
    }

}