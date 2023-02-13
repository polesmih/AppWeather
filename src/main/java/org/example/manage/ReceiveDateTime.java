package org.example.manage;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ReceiveDateTime {

    public static String getCurrentDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy\nEEEE", Locale.getDefault());
        return date.format(formatter);
    }

    public static String getCurrentShortDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.getDefault());
        return date.format(formatter);
    }

    public static String getCurrentTime()  {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault());
        return time.format(formatter);
    }

    public static String getSunEventPiter(long sunTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm", Locale.getDefault());
        String formattedDtm = Instant.ofEpochSecond(sunTime)
                .atZone(ZoneId.of("GMT+3"))
                .format(formatter);
        return formattedDtm;
    }


}
