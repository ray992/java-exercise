package com.exercise.algorithm.day;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DayOfYear
 * @Description 一年中的第几天
 * @Author yeqiang
 * @Date 2021/12/21 上午9:58
 * @Version 1.0
 **/
public class DayOfYear {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        try {
            Date parseDate = dateFormat.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parseDate);
            return calendar.get(Calendar.DAY_OF_YEAR);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int dayOfYear2(String date) {
       String[] ss = date.split("-");
       int year = Integer.parseInt(ss[0]);
       int month = Integer.parseInt(ss[1]);
       int day = Integer.parseInt(ss[2]);
       int res = 0;
       for (int i = 0; i < month-1; i++){
           if (i == 1 && leapYear(year)){
               days[i] = 29;
           }
           res+=days[i];
       }
       return res + day;
    }

    public boolean leapYear(Integer year){
        return year % 4 == 0;
    }

    public static void main(String[] args) {
        DayOfYear dayOfYear = new DayOfYear();
        System.out.println(dayOfYear.dayOfYear2("2019-01-09"));
        System.out.println(dayOfYear.dayOfYear2("2019-02-10"));
        System.out.println(dayOfYear.dayOfYear2("2003-03-01"));
        System.out.println(dayOfYear.dayOfYear2("2004-03-01"));
    }
}
