package com.exercise.algorithm.day;

import java.util.*;

/**
 * @ClassName RecentCounter
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/7/29 下午10:54
 * @Version 1.0
 **/
public class RecentCounter {

    private static Deque<Integer> requestQueue = new LinkedList<>();

    private static Deque<Integer> tempSaveQueue = new LinkedList<>();

    public RecentCounter() {

    }

    public static int ping(int t) {
        requestQueue.addLast(t);
        int start = t - 3000;
        int requestCount = 0;
        while (!requestQueue.isEmpty()){
            int currentRequest = requestQueue.pollLast();
            if (currentRequest < start){
                break;
            }
            tempSaveQueue.addLast(currentRequest);
            requestCount++;
        }
        while (!tempSaveQueue.isEmpty()){
            requestQueue.addLast(tempSaveQueue.pollLast());
        }
        return requestCount;
    }

    public static void main(String[] args) {
        System.out.println(ping(1));
        System.out.println(ping(100));
        System.out.println(ping(3001));
        System.out.println(ping(3002));
    }
}
