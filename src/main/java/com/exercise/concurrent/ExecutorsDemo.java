package com.exercise.concurrent;

import java.util.concurrent.*;

/**
 * @ClassName ExecutorsDemo
 * @Description TODO
 * @Author yeqiang
 * @Date 2022/4/14 10:51 PM
 * @Version 1.0
 **/
public class ExecutorsDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() ->{
                executeOperation();

        });
        System.out.println("run finish");
        //System.out.println(future.get());
       Thread.sleep(10);
    }

    public static void executeOperation() {
        int n = 1 % 0;
        System.out.println(n);
        return;
    }
}
