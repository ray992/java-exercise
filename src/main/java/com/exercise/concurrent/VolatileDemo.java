package com.exercise.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName VolatileDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2020/10/8 3:59 下午
 * @Version 1.0
 **/
public class VolatileDemo {

    private static volatile int t = 0;

    private static final CountDownLatch latch = new CountDownLatch(10);

    private  static void inc(){
        t++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i ++){
            new Thread(){
                @Override
                public void run() {
                    for (int j = 0 ; j < 10000; j ++){
                        inc();
                    }
                    latch.countDown();
                }
            }.start();
        }
        latch.await();
        System.out.println(t);
    }
}
