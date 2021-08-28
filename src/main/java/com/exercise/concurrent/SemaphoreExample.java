package com.exercise.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreExample
 * @Description 信号量
 * @Author yeqiang
 * @Date 2021/8/5 下午4:48
 * @Version 1.0
 **/
public class SemaphoreExample {

    private final ExecutorService executorService;
    private final Semaphore semaphore;

    public SemaphoreExample(ExecutorService executorService, int semaphore) {
        this.executorService = executorService;
        this.semaphore = new Semaphore(semaphore);
    }

    public void mutex(String s) throws InterruptedException {
        semaphore.acquire();
        System.out.println(s+" acquire");
        Thread.sleep(2000);
        semaphore.release();
        System.out.println(s+" release");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        SemaphoreExample semaphoreExample = new SemaphoreExample(executorService, 2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphoreExample.mutex("abc");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphoreExample.mutex("efg");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphoreExample.mutex("hij");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        });
        executorService.shutdown();
    }
}
