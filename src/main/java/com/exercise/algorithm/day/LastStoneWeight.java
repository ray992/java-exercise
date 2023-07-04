package com.exercise.algorithm.day;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName LastStoneWeight
 * @Description 最后一块石头的重量
 * @Author yeqiang
 * @Date 2022/7/9 9:50 AM
 * @Version 1.0
 **/
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((a, b) -> b -a);
        for (int stone:stones){
            priorityQueue.add(stone);
        }
        while (priorityQueue.size() > 1){
            int y = priorityQueue.poll();
            int x = priorityQueue.poll();
            if (y != x){
                priorityQueue.add(y - x);
            }
        }
        return priorityQueue.peek() == null ? priorityQueue.peek():0;
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        System.out.println(lastStoneWeight.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
