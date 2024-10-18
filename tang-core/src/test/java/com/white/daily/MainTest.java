package com.white.daily;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Set;

/**
 * @author tcs
 * @date Created in 2021-04-28
 */
public class MainTest {

    @Test
    public void testLocalDate() {
        LocalDate now = LocalDate.now().minus(1, ChronoUnit.DAYS);
        boolean leapYear = now.isLeapYear();
        System.out.println(now);
    }

    @Test
    public void testLocalTime() {
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }

    @Test
    public void testZonedDateTime() {
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(allZoneIds);
    }

    @Test
    public void testPeriod() {
        LocalDate start = LocalDate.parse("2015-10-08");
        LocalDate end = LocalDate.parse("2019-06-27");
        int between = Period.between(start, end).getDays();
        System.out.println(between);

        long between1 = ChronoUnit.DAYS.between(start, end);
        long year = ChronoUnit.YEARS.between(start, end);
        System.out.println(year);
        System.out.println(between1);
    }

    @Test
    public void testDuration(){
        LocalTime start = LocalTime.parse("17:18:18");
        LocalTime end = LocalTime.parse("07:18:18");
        long minutes = ChronoUnit.MINUTES.between(end, start);
        long hours = ChronoUnit.HOURS.between(end, start);
        System.out.println(minutes);
        System.out.println(hours);
    }
}
