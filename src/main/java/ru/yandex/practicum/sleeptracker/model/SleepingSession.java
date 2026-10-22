package ru.yandex.practicum.sleeptracker.model;

import java.time.Duration;
import java.time.LocalDateTime;

public class SleepingSession implements Comparable<SleepingSession> {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private SleepStatus status;

    public SleepingSession(LocalDateTime startTime, LocalDateTime endTime, SleepStatus status) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }


    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public SleepStatus getStatus() {
        return status;
    }

    @Override
    public int compareTo(SleepingSession other) {
        Duration thisDuration = Duration.between(startTime, endTime);
        Duration otherDuration = Duration.between(other.startTime, other.endTime);

        return thisDuration.compareTo(otherDuration);
    }

}
