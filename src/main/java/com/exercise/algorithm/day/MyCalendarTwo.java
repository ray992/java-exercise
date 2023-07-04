package com.exercise.algorithm.day;

import javafx.util.Pair;

import java.util.*;

/**
 * 我的日程安排表II
 * @author yeqiang
 * @date 2022/7/19
 * @param
 * @return
*/
public class MyCalendarTwo {
    TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>((x, y) -> y - x);
    }

    public boolean book(int start, int end) {
        int temp = 0;
        int ans = 0;
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        //恢复所有的值 采取了逆向恢复 和正向恢复都一样
        for (Integer key : map.keySet()) {
            temp = temp - map.get(key);
            ans = Math.max(ans, temp);
            if (ans > 2) {
                map.put(start, map.getOrDefault(start, 0) - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 55));
    }
}
