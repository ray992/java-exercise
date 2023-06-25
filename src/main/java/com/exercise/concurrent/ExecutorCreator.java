package com.exercise.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ExecutorCreator {

    public void init() throws ExecutionException, InterruptedException {
        // 线程池中线程数量么有固定，可以达到最大值
        Executors.newCachedThreadPool(); // 可以无限增加线程， 队列不用来存储任务，只负责进行中转和传递， 效率比较高
        Executors.newFixedThreadPool(10); // 核心线程数等于最大线程数
        Executors.newSingleThreadExecutor(); // 只有一个线程去处理任务，可保证任务执行顺序
        Executors.newScheduledThreadPool(10); // 支持定时和周期性执行任务
        Executors.newSingleThreadScheduledExecutor(); // 是只有一个线程newScheduledThreadPool的特例
        ForkJoinPool forkJoinPool = new ForkJoinPool(); //计算机多核优势
        Object result = new Object();
        ForkJoinTask forkJoinTask = forkJoinPool.submit(new Runnable() {
            @Override
            public void run() {
                
            }
        }, result);
        forkJoinTask.get();
    }
}
