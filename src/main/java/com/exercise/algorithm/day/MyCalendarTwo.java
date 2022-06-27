package com.exercise.algorithm.day;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    List<int[]>  bookList = null;

    public MyCalendarTwo() {
        bookList = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int bookCount = 1;
        for (int[] book: bookList){
            if ((end > book[0]  && end < book[1]) || (start > book[0]  && start < book[1])){
                bookCount++;
            }
            if (bookCount >= 3){
                return false;
            }
        }
        return bookList.add(new int[]{start, end});
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
    }
}
