package com.exercise.concurrent;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @ClassName BlockingQueueDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/5/5 10:24 PM
 * @Version 1.0
 **/
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>(2);
        System.out.println(blockingDeque.element());
        for (int i = 0 ; i < 3; i++){
            blockingDeque.add(1);
        }
    }
}
