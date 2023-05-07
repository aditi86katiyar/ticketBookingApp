package com.sapient.util;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static ZonedDateTime dateConverter(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        // Parse the date string into LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);

        // Assign the time zone (e.g., UTC)
        ZoneId zoneId = ZoneId.of("UTC");

        // Convert LocalDateTime to ZonedDateTime with the specified time zone
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        
        System.out.println("ZonedDateTime: " + zonedDateTime);

        
        return zonedDateTime;

    }
}
