package com.exercise.collection;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @ClassName PriorityQueueDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/1 上午10:16
 * @Version 1.0
 **/
public class PriorityQueueDemo {

    public static void main(String[] args) {
        Random rand = new Random();
        Queue<Integer> queue = new PriorityQueue<>(10);
        for (int i = 0; i < 10; i++){
            queue.add(rand.nextInt(10000));
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
