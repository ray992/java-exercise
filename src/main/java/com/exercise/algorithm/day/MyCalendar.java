package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    List<int[]> bookList = null;

    public MyCalendar() {
        bookList = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] book:bookList){
            int s = book[0];
            int e = book[1];
           if (start < e && end > s){
               return false;
           }
        }
        bookList.add(new int[]{start, end});
        return true;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}
