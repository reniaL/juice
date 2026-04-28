package com.juice.jdk8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public final class DateTimeExample {

    private DateTimeExample() {
    }

    public static void demo() {
        LocalDate releaseDate = LocalDate.of(2014, 3, 18);
        LocalDate projectStart = LocalDate.of(2026, 4, 28);
        Period duration = Period.between(releaseDate, projectStart);
        LocalDateTime meeting = LocalDateTime.of(projectStart, LocalTime.of(10, 30));

        System.out.println("[DateTime] release date: " + releaseDate);
        System.out.println("[DateTime] years since release: " + duration.getYears());
        System.out.println("[DateTime] meeting time: "
                + meeting.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
}
