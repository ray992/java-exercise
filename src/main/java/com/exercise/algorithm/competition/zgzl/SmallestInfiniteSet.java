package com.exercise.algorithm.competition.zgzl;

import java.util.PriorityQueue;

/**
 * @ClassName SmallestInfiniteSet
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/7/10 10:43 AM
 * @Version 1.0
 **/
public class SmallestInfiniteSet {

    PriorityQueue<Integer> priorityQueue;

    public SmallestInfiniteSet() {
        priorityQueue = new PriorityQueue<>();
        for (int i = 1; i <= 1000;i++){
            priorityQueue.offer(i);
        }
    }

    public int popSmallest() {
        if (!priorityQueue.isEmpty()){
            return priorityQueue.poll();
        }
        return -1;
    }

    public void addBack(int num) {
        if (!priorityQueue.contains(num)){
            priorityQueue.offer(num);
        }
    }
}
