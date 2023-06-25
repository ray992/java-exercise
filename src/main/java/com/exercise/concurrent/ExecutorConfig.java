package com.exercise.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ExecutorConfig {

    private static final int maxPoolSize = Runtime.getRuntime().availableProcessors();

    private static volatile ExecutorService executorService;

    private static ExecutorService getThreadPool(){
        if (executorService == null){
            synchronized (ExecutorConfig.class){
                if (executorService == null){
                    executorService = newThreadPool();
                }
            }
        }
        return executorService;
    }

    private static ExecutorService newThreadPool(){
        int queueSize = 1000;
        int corePoolSize = Math.min(4, maxPoolSize);
        return new ThreadPoolExecutor(corePoolSize, maxPoolSize, 100, TimeUnit.SECONDS, new LinkedBlockingDeque<>(queueSize), new ThreadPoolExecutor.AbortPolicy());
    }

    private ExecutorConfig(){

    }

    public static String input(int a){
        try {
            int b = a / 0;
        }catch (Exception e){
            log.error("input exception", e);
        }
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        return "ok";
    }


    public static void main(String[] args) {
        System.out.println(input(1));
    }

}
