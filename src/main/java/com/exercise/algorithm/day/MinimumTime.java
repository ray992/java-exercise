package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class MinimumTime {

    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        int sumTime = 0;
        int sumTrip = 0;
        Map<Integer, Integer[]> tripMap = new LinkedHashMap<>();
        for (int i = 0; i < time.length; i++){
            tripMap.put(i, new Integer[]{time[i], 0});
        }
        while (sumTrip < totalTrips){
            sumTime++;
            for (Map.Entry<Integer, Integer[]> map:tripMap.entrySet()){
                Integer key = map.getKey();
                Integer[] valArray = map.getValue();
                Integer costTime = valArray[0];
                Integer costCount = valArray[1];
                if (costCount + 1 >= costTime){
                    sumTrip++;
                    tripMap.put(key, new Integer[]{costTime, 0});
                }else {
                    tripMap.put(key, new Integer[]{costTime, costCount+1});
                }
                if (sumTrip >= totalTrips){
                    break;
                }
            }
        }
        return sumTime;
    }

    public long minimumTime2(int[] time, int totalTrips) {
        int n = time.length;
        int[] count = new int[n];
        Arrays.fill(count, 0);
        long costTime = 0;
        int useTrip = 0;
        while (useTrip < totalTrips){
            costTime++;
            for (int i = 0; i < n; i++){
                if (count[i] + 1 >= time[i]){
                    useTrip ++;
                    count[i] = 0;
                }else {
                    count[i] = count[i] + 1;
                }
                if (useTrip >= totalTrips){
                    break;
                }
            }
        }
        return costTime;
    }

    public long minimumTime3(int[] time, int totalTrips){
        long max = 0;
        for (int t:time){
            max = Math.max(max, (long)totalTrips*t);
        }
        long l = 1;
        long r = max;
        while (l <= r){
            long mid = l + ((r - l) >> 1);
            // 完成趟数
            long roll = cal(time, mid, totalTrips);
            if (roll < totalTrips) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    // curTime时刻，已经完成的趟数
    private long cal(int[] time, long curTime, int totalTrips) {
        int res = 0;
        for (int t : time) {
            res += curTime / t;
            if (res > totalTrips) {
                return res;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        MinimumTime minimumTime = new MinimumTime();
        System.out.println(minimumTime.minimumTime3(new int[]{1, 2, 3}, 5));
        System.out.println(minimumTime.minimumTime3(new int[]{2}, 1));
        System.out.println(minimumTime.minimumTime3(new int[]{5, 10, 10}, 9));
        //5, 1 | 10 4 | 15  5 | 20 8 | 25 9
    }
}
