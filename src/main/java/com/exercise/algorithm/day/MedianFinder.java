package com.exercise.algorithm.day;

import java.util.PriorityQueue;

/**
 * @ClassName MedianFinder
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/27 上午9:17
 * @Version 1.0
 **/
public class MedianFinder {

    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    /** initialize your data structure here. */
    public MedianFinder() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a)); //大顶
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b)); //小顶
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }

    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queMin = new PriorityQueue<Integer>((a, b) -> (b - a)); //大顶
        queMin.add(5);
        queMin.add(3);
        queMin.add(6);
        System.out.println(queMin.peek());
    }
}
