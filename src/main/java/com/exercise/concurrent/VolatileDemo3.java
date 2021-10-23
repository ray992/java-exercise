package com.exercise.concurrent;

import lombok.SneakyThrows;

/**
 * @ClassName VolatileDemo3
 * @Description TODO
 * @Author yeqiang
 * @Date 2021/10/19 下午11:34
 * @Version 1.0
 **/
public class VolatileDemo3 {

    private volatile int i;

    public void addI(){
        synchronized (this){
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo3 volatileDemo3 = new VolatileDemo3();
        for (int i = 0 ; i < 1000; i++){
            new Thread(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    Thread.sleep(10);
                    volatileDemo3.addI();
                }
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(volatileDemo3.i);
    }
}
