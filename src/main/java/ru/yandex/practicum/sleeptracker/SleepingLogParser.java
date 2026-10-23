package ru.yandex.practicum.sleeptracker;

import ru.yandex.practicum.sleeptracker.model.SleepStatus;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

public class SleepingLogParser {

    public List<SleepingSession> parse(String path) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
            return Files.readAllLines(Path.of(path))
                    .stream()
                    .map(convertToSession(formatter))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Function<String, SleepingSession> convertToSession(DateTimeFormatter formatter) {
        return line -> {
            String[] args = line.split(";");
            LocalDateTime start = LocalDateTime.parse(args[0], formatter);
            LocalDateTime end = LocalDateTime.parse(args[1], formatter);
            SleepStatus status = SleepStatus.valueOf(args[2]);
            return new SleepingSession(start, end, status);
        };
    }

}
