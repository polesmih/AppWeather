package org.example.manage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class ReceiveDateTime {

    public static String getCurrentDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy\nEEEE", Locale.getDefault());
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

    public static String formattingDateTime(String oldDateTime) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            Date date = dt.parse(oldDateTime);
            SimpleDateFormat newDateTime = new SimpleDateFormat("dd.MM.yyyy в HH:mm");
            oldDateTime = newDateTime.format(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return oldDateTime;
    }


}
