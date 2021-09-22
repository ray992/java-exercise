package com.exercise.algorithm.day;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName SmallestK
 * @Description 最小K个数
 * @Author yeqiang
 * @Date 2021/9/3 上午9:49
 * @Version 1.0
 **/
public class SmallestK {

    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int val:arr){
            priorityQueue.add(val);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++){
            result[i] = priorityQueue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        SmallestK smallestK = new SmallestK();
        System.out.println(Arrays.toString(smallestK.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 2)));
    }
}
