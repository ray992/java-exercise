package com.exercise.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Mutex
 * @Description TODO
 * @Author yeqiang
 * @Date 2020/10/7 10:18 下午
 * @Version 1.0
 **/
public class Mutex {

    private static final Object MUTEX = new Object();

    public void access(){
        synchronized (MUTEX){
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Mutex mutex = new Mutex();
        for (int i = 0; i < 5; i++){
            new Thread(mutex::access).start();
        }
    }
}
