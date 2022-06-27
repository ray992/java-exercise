package com.exercise.feature.lambda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class KiteFunctionExecute {

    public static void main(String[] args) throws InterruptedException {
        String formatLocalDateTime = new KiteFunction<LocalDateTime, String, String>(){
            @Override
            public String run(LocalDateTime localDateTime, String s) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(s);
                return formatter.format(localDateTime);
            }
        }.run(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(formatLocalDateTime);

        TimeUnit.SECONDS.sleep(1);

        KiteFunction<LocalDateTime, String, String> kiteFunction = (LocalDateTime localDateTime, String pattern) ->{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
            return localDateTime.format(dateTimeFormatter);
        };
        System.out.println(kiteFunction.run(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss"));
    }
}
