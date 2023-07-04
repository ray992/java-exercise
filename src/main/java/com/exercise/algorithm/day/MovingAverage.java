package com.exercise.algorithm.day;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName MovingAverage
 * @Description 滑动窗口的平均值
 * @Author yeqiang
 * @Date 2022/7/16 9:46 AM
 * @Version 1.0
 **/
public class MovingAverage {

    private final int size;

    private double sum = 0;

    private int curSize;

    private Deque<Integer> deque;


    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.deque = new ArrayDeque<>();
        this.curSize = 0;
    }

    public double next(int val) {
        if (curSize + 1 > size){
            int headVal = deque.pollFirst();
            curSize--;
            sum -= headVal;
        }
        deque.offerLast(val);
        curSize++;
        sum += val;
        return sum / curSize;
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}
