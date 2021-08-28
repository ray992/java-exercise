package com.exercise.algorithm;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName LinkBlockingQueueDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/8/5 上午11:37
 * @Version 1.0
 **/
public class LinkBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>();
        linkedBlockingDeque.put(1);
        linkedBlockingDeque.offer(2);
        System.out.println(linkedBlockingDeque.take());
        System.out.println(linkedBlockingDeque.poll());
    }
}
