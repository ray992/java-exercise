package com.exercise.feature.time;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName TimeIntroduction
 * @Description java8特性 时间和日期
 * @Author yeqiang
 * @Date 2021/10/14 下午6:01
 * @Version 1.0
 **/
public class TimeIntroduction {

    public static void main(String[] args) {
        System.out.println(Instant.now().getEpochSecond());
        System.out.println(Instant.now().toEpochMilli());
        Clock clock = Clock.systemUTC();
        System.out.println(Instant.now(clock).toEpochMilli());
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.of(1994, 5, 1, 23, 59, 59);
        System.out.println(localDateTime1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime2 = LocalDateTime.parse("2021/09/10 21:34:12", dateTimeFormatter);
        System.out.println(localDateTime2);
        System.out.println(localDateTime2.getYear());
        System.out.println(localDateTime2.getMonth());
        System.out.println(localDateTime2.getDayOfMonth());
        System.out.println(localDateTime2.getDayOfMonth());
        System.out.println(localDateTime2.getDayOfWeek());
        System.out.println(localDateTime2.getHour());
        System.out.println(localDateTime2.getMinute());
        System.out.println(localDateTime2.getSecond());
        System.out.println(localDateTime2.getNano());
    }
}
