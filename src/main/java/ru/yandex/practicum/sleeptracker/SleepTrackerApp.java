package ru.yandex.practicum.sleeptracker;

import ru.yandex.practicum.sleeptracker.function.FunctionFactory;
import ru.yandex.practicum.sleeptracker.model.SleepAnalysisResult;
import ru.yandex.practicum.sleeptracker.model.SleepingSession;

import java.util.List;
import java.util.function.Function;

public class SleepTrackerApp {

    public static void main(String[] args) {
        SleepingLogParser sleepingLogParser = new SleepingLogParser();
        List<SleepingSession> sessions = sleepingLogParser.parse(args[0]);
        List<Function<List<SleepingSession>, SleepAnalysisResult>> functions = FunctionFactory.getFunctions();
        functions.stream()
                .map(func -> func.apply(sessions))
                .forEach(sleepAnalysisResult ->
                        System.out.println(sleepAnalysisResult.getDescription() + sleepAnalysisResult.getValue()));

    }
}