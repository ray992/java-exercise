package com.exercise.algorithm.day;

import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName MyCalendarI
 * @Description 我的日程安排表
 * @Author yeqiang
 * @Date 2022/7/5 8:30 AM
 * @Version 1.0
 **/
public class MyCalendarI {

    TreeMap<Integer, Integer> bookMap;

    public MyCalendarI() {
        bookMap = new TreeMap<>();
    }

    public boolean book(int start, int end){
       // 不大于指定key的最大键值所对应的键值对
       Map.Entry<Integer, Integer> floorEntry = bookMap.floorEntry(start);
       if (floorEntry != null){
            //int floorStart = floorEntry.getKey();
            int floorEnd = floorEntry.getValue();
            if (start <= floorEnd){
                return false;
            }
       }
       // 不小于指定key的最小键值所对应的键值对
       Map.Entry<Integer, Integer> ceilingEntry = bookMap.ceilingEntry(start);
       if (ceilingEntry != null){
           int ceilingStart = ceilingEntry.getKey();
           //int ceilingEnd = ceilingEntry.getValue();
           if (end >= ceilingStart){
               return false;
           }
       }
       bookMap.put(start, end);
       return true;
    }

    public static void main(String[] args) {
        MyCalendarI myCalendarI = new MyCalendarI();
        System.out.println(myCalendarI.book(10,20));
        System.out.println(myCalendarI.book(15,25));
        System.out.println(myCalendarI.book(20,30));
    }

}
