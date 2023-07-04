package com.exercise.algorithm.day;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName MinRefuelStops
 * @Description 最低加油次数
 * @Author yeqiang
 * @Date 2022/7/2 9:25 AM
 * @Version 1.0
 **/
public class MinRefuelStops {

    // 贪心 + 优先级队列
    public int minRefuelStops(int target, int startFuel, int[][] stations){
        int n = stations.length;
        PriorityQueue<Integer> fuelPriorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int ans = 0;
        int curRunDistance = startFuel;
        int i = 0;
        while (curRunDistance < target){
            if (i < n && curRunDistance >= stations[i][0]){
                fuelPriorityQueue.offer(stations[i][1]);
                i++;
            }else {
                if (!fuelPriorityQueue.isEmpty()){
                    curRunDistance += fuelPriorityQueue.poll();
                    ans++;
                }else {
                    return -1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinRefuelStops minRefuelStops = new MinRefuelStops();
        System.out.println(minRefuelStops.minRefuelStops(100, 10, new int[][]{ {10,60}, {20,30}, {30,30}, {60,40}  }));
    }
}
